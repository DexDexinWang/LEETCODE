'''
Created on Mar 6, 2017

@author: dexinwang
'''

import copy
import sys
import re
import math
import operator
import time
import numpy as np
from numpy import delete
from sklearn.model_selection import cross_val_score
from sklearn import svm
from sklearn.neighbors.nearest_centroid import NearestCentroid
from sklearn.linear_model import SGDClassifier
from sklearn.kernel_approximation import RBFSampler
from sklearn.naive_bayes import GaussianNB
from sklearn.ensemble import RandomForestClassifier
import matplotlib.pyplot as plt
from findertools import sleep


#1. read data from a file
#2. ignore duplicated record
#3. count the number of values for each feature
def read_data(filename):
    f = open(filename, 'r')
    p = re.compile(',')
    data = []
    header = f.readline().strip()
    varnames = p.split(header)

    #get the index of the primary key feature in order to delete duplicated informaiton
    index_primary=varnames.index('movie_title')

    counter_list=[{}]
    for l in f:
        row = []
        #indicate whether this value is duplicated for the primary key
        index=0
        flag=True
        for x in p.split(l.strip()):
            row.append(x)
            #count the values in each feature
            if(len(counter_list)<=index):
                counter_list.append({})
            if x:
                if x in counter_list[index].keys():
                    #consider the duplicated data with primary key 
                    if (index == index_primary):
                        flag=False
                    else:
                        counter_list[index][x]=counter_list[index][x]+1
                else:
                    counter_list[index][x]=1
            index=index+1      
        if(flag):
            data.append(row)
        flag=True
        #update all feature counters 
    return (data, varnames,counter_list)


#get the indexes for each  

def check_indexes(varnames,delete_attributes):
    result=[]
    for x in delete_attributes:
        result.append(varnames.index(x))
    result.reverse()
    return result

#delete some unnecessary features such as title and 

def delete_varnames(dv_data, dv_varnames, dv_counter_list, dv_delete_indexes):
    #delete features from varnames
    for y in dv_delete_indexes:
        dv_varnames = dv_varnames[:y]+dv_varnames[y+1:]
        dv_counter_list = dv_counter_list[:y]+dv_counter_list[y+1:]
    #delete features from data
    for x in range(len(dv_data)):
        for y in dv_delete_indexes:
            dv_data[x]=dv_data[x][:y]+ dv_data[x][y+1:]
    return (dv_data,dv_varnames,dv_counter_list)

#switch the predicted feature with the last one attribute 
def switch_varnames (data,varnames, counter_list, switch_indexes):
    #delete features from sortvarnames
    a,b = switch_indexes
    varnames[a], varnames[b]=varnames[b],varnames[a]
    #delete features from data
    for x in range(len(data)):
        data[x][a],data[x][b]=data[x][b],data[x][a]

#consider whether a value could be integer type
def isint(value):
    try:
        int(value)
        return True
    except ValueError:
        return False
    
#consider whether a value could be float type
def isfloat(value):
    try:
        float(value)
        return True
    except ValueError:
        return False
    
    
#consider whether a value means multi-values 
def check_symbol(varname):
    temp=['plot_keywords','genres']
    if varname in temp:
        return True
    return False


#extend features 
def extended_data(data, varnames, counter_list, index ,limit):
    #get the number of features.
    features = separate_value(data,index,limit)
    #create new varnames
    varnames = varnames[:index] + varnames[index+1:]
    counter_list = counter_list[:index] + counter_list[index+1:]
    new_features = varnames+features
     
    new_data=[]
    #create new data 
    for x in range(len(data)):
        new_array=[0]*(len(features))
        temp=data[x][index]
        p = re.compile('\\|')
        temp_list= p.split(temp)
        for y in temp_list:
            if y in features:
                new_array[features.index(y)]=1
        data[x]=data[x][:index]+data[x][index+1:]
        new_row= data[x]+new_array
        new_data.append(new_row)
    return new_data,new_features
        
            
def separate_value(data, index, limit):
    list_result = {}
    for x in range(len(data)):
        temp=data[x][index]
        p = re.compile('\\|')
        temp_list= p.split(temp)
        for y in temp_list:
            if y in list_result:
                list_result[y]=list_result[y]+1
            else:    
                list_result[y]=1    
    sorted_x= sorted(list_result.items(), key=operator.itemgetter(1),reverse=True)
    #return the limit number of attributes     
    result=[]
    if limit >=0 and len(sorted_x) >=limit:
        number_attrubtes= limit
    else:
        number_attrubtes= len(sorted_x)

    for x in range(number_attrubtes):
        result.append(sorted_x[x][0])
    return result

def extended_data_without_symbol(edws_data,edws_varnames,edws_counter_list,index,limit):
    features = sort_dictionary(edws_counter_list[index],limit)

    edws_varnames = edws_varnames[:index]+edws_varnames[index+1:]
    edws_counter_list = edws_counter_list[:index] + edws_counter_list[index+1:]
    
    new_features=edws_varnames+features
    
    new_data=[]
    #create new data 
    for x in range(len(edws_data)):
        new_array=[0]*(len(features))
        temp=edws_data[x][index]
        if temp in features:
            new_array[features.index(temp)]=1
        edws_data[x]=edws_data[x][:index]+edws_data[x][index+1:]
        new_row= edws_data[x]+new_array
        new_data.append(new_row)
    return new_data,new_features
        
def sort_dictionary(dic,limit):
    result=[]
    sorted_x = sorted(dic.items(), key=operator.itemgetter(1))
    sorted_x.reverse()
    if len(sorted_x)>=limit:
        reuslt=sorted_x[:limit]
    else:
        return sorted_x
    return result

#extend features with "bag of words"
def extend_features(data, varnames, counter_list,extend_indexes,limit):
    for x in extend_indexes:
        if check_symbol(varnames[x]):
            data,varnames=extended_data(data,varnames,counter_list,x,limit)
        else:
            data,varnames=extended_data_without_symbol(data,varnames,counter_list,x,limit)
    return data,varnames     

#calculate the mean 
def calc_ms(data, counter_list, zscore_indexes):
    zscore_dic={}
    for x in zscore_indexes:
        keys=counter_list[x].keys()
        values=counter_list[x].values()
        
        #calculate the mean
        total=0
        counter=0
        for y in range(len(counter_list[x])):
            total+=float(keys[y])*values[y]
            counter+=values[y]
        mean = total/counter
        
        #calculate the standard deviation
        total = 0
        counter = 0 
        for y in range(len(counter_list[x])):
            total+= values[y]*((float(keys[y])-mean)**2)
            counter+=values[y]
        sd = math.sqrt( total/counter)
        #add it into z-score dictionary
        zscore_dic[x]=[mean, sd]
    return zscore_dic

# get the train data and test data 
def separate(data):
    size = len(data)
    train_size = int(0.8*size)
    #
    train =data[:train_size]
    test =data[train_size:]
    
    train_varnames =[]
    train_labels = [] 
    test_varnames =[]
    test_labels =[]
    
    for x in range(len(train)):
        train_varnames.append(train[x][:-1]) 
        train_labels.append(train[x][-1:][0]) 
    
    for x in range(len(test)):
        test_varnames.append(test[x][:-1]) 
        test_labels.append(test[x][-1:][0]) 
    
    return (train_varnames, train_labels, test_varnames, test_labels)

#update values with z score normalization
def update(ud_data,zscore_indexes,zscore_dic):
    for x in range(len(ud_data)):
        for y in zscore_indexes:
            if ud_data[x][y]:
                ud_data[x][y]= (float(ud_data[x][y]) - zscore_dic[y][0])/zscore_dic[y][1]
            else:
                ud_data[x][y]=0

#Change the regression question as classification question
def predict_transfer(data,index):
    for x in range(len(data)):
        data[x][index]=int(float(data[x][index])+0.5)

#calculate the accuracy for the predicted result
def calculator(predict_result, test_labels):
    total=0.0
    counter=0.0
    for x in range(len(predict_result)):
        if predict_result[x] == int(test_labels[x]):
            total+=1
        counter+=1
    return total/counter

#separate the String features and Number features
def get_number_string_index(gnsi_data,gnsi_varnames):
    ei = []
    zsi = []
    for x in range(len(gnsi_data[0])):
        if not (isint(gnsi_data[0][x]) or isfloat(gnsi_data[0][x])):
            ei.append(x)
        else:
            if  gnsi_varnames[x] != 'imdb_score':
                zsi.append(x)
    ei.reverse()
    return (ei,zsi)

#Data clean
def data_transer(data, varnames,counter_list,delete_atrributes,limit):
    dt_data = copy.copy(data)
    dt_varnames = copy.copy(varnames)
    dt_counter_list = copy.copy(counter_list)
    
    delete_indexes= check_indexes(dt_varnames,delete_atrributes)
    (dt_data,dt_varnames,dt_counter_list) = delete_varnames(dt_data, dt_varnames, dt_counter_list, delete_indexes) 
    
    #get the indexes for the String features and Int features
    (extend_indexes, zscore_indexes) = get_number_string_index(dt_data, dt_varnames)
    
    #update data with z-score normalization
    zscore_dic=calc_ms(dt_data, dt_counter_list, zscore_indexes)
    update(dt_data, zscore_indexes, zscore_dic)

    #extend features for text features
    (new_dt_data, new_dt_varnames)=extend_features(dt_data, dt_varnames, dt_counter_list,extend_indexes,limit)
     
    #switch the predicted feature with the last feature
    switch_attributes=['imdb_score']
    switch_attributes.append(new_dt_varnames[-1])
    switch_indexes = check_indexes(new_dt_varnames,switch_attributes)
    switch_varnames(new_dt_data, new_dt_varnames, counter_list, switch_indexes)
    
    return new_dt_data , new_dt_varnames



def data_transer1(data, varnames,counter_list,delete_atrributes,limit):
    dt_data = copy.copy(data)
    dt_varnames = copy.copy(varnames)
    dt_counter_list = copy.copy(counter_list)
    
    delete_indexes= check_indexes(dt_varnames,delete_atrributes)
    (dt_data,dt_varnames,dt_counter_list) = delete_varnames(dt_data, dt_varnames, dt_counter_list, delete_indexes) 
    
    #get the indexes for the String features and Int features
    (extend_indexes, zscore_indexes) = get_number_string_index(dt_data, dt_varnames)
    
    #update data with z-score normalization
    zscore_dic=calc_ms(dt_data, dt_counter_list, zscore_indexes)
    update(dt_data, zscore_indexes, zscore_dic)

    
    #switch the predicted feature with the last feature
    switch_attributes=['imdb_score']
    switch_attributes.append(dt_varnames[-1])
    switch_indexes = check_indexes(dt_varnames,switch_attributes)
    switch_varnames(dt_data, dt_varnames, counter_list, switch_indexes)
    return dt_data , dt_varnames

#based on result and accuracy compute the final result.
def final_computation(results,test_labels):
    #count the value * accuracy for each predicted value
    final_labels=[]
    for x in range(len(results)):
        index =0 
        for y in range(len(results[x][0])):
            if len(final_labels)<=index:
                final_labels.append({})
            value = results[x][0][y]
            
            if value in final_labels[y].keys():
                final_labels[y][value]=final_labels[y][value] + results[x][1]
            else: 
                final_labels[y][value]= results[x][1]
            index+=1
            
    #choose the biggest value for each numnber
    final_predictions=[]
    for x in range(len(final_labels)):
        sorted_x = sorted(final_labels[x].items(), key=operator.itemgetter(1))
        sorted_x.reverse()
        final_predictions.append(sorted_x[0][0]) 
    
    accuracy = calculator(final_predictions, test_labels)
    print "The final accuracy is:",accuracy
    
#run different algorithms and return the accuracy
def run_algorithms(ras_data):
    #separate data as training data and test data
    results=[]
    (ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels) = separate(ras_data)
    #results.append(run_svm(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    #results.append(run_sgd(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    #results.append(run_ka(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    #results.append(run_knn(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    results.append(run_gnb(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    #results.append(run_frt(ras_train_varnames, ras_train_labels, ras_test_varnames, ras_test_labels))
    final_computation(results,ras_test_labels)


#Ensemble-Forests of randomized trees
def run_frt(train_varnames, train_labels,test_varnames, test_labels):
    clf = RandomForestClassifier(n_estimators=10)
    result,accuracy=fit_predict(clf,"Forests of randomized trees",train_varnames, train_labels,test_varnames, test_labels)
    return result,accuracy

#Gaussian Naive Bayes 0.111
def run_gnb(train_varnames, train_labels,test_varnames, test_labels):
    gnb = GaussianNB()
    result,accuracy=fit_predict(gnb,"Gaussian Naive Bayes",train_varnames, train_labels,test_varnames, test_labels)
    return result,accuracy

#Kernel Approximation 0.279
def run_ka(train_varnames, train_labels,test_varnames, test_labels):
    rbf_feature = RBFSampler(gamma=1, random_state=1)
    X_features = rbf_feature.fit_transform(train_varnames)
    X_features_test = rbf_feature.fit_transform(test_varnames)
    clf=SGDClassifier()
    result,accuracy=fit_predict(clf,"Kernel Approximation", X_features, train_labels,X_features_test, test_labels)
    return result,accuracy
#SGD 0.398
def run_sgd(train_varnames, train_labels,test_varnames, test_labels):
    clf=SGDClassifier(loss="hinge", penalty="l2")
    result,accuracy=fit_predict(clf,"SGD", train_varnames, train_labels,test_varnames, test_labels)
    return result,accuracy
    
#Linear SVM 0.408  
def run_svm(train_varnames, train_labels,test_varnames, test_labels):
    clf=svm.LinearSVC()
    result,accuracy=fit_predict(clf,"Linear SVM", train_varnames, train_labels,test_varnames, test_labels)
    return result,accuracy

#KNN, Nearest Centroid Classifier
def run_knn(train_varnames, train_labels,test_varnames, test_labels):
    clf=NearestCentroid()
    result,accuracy=fit_predict(clf,"Nearest Centroid Classifier", train_varnames, train_labels,test_varnames, test_labels)
    return result,accuracy

def fit_predict(algorithm, algorithm_name, train_varnames, train_labels,test_varnames, test_labels):
    

    scores = cross_val_score(algorithm, train_varnames, train_labels, cv=5)
    print algorithm_name,"'s mean accuracy: %0.2f (+/- %0.2f)" % (scores.mean(), scores.std() * 2)
    
    a=time.time()
    algorithm.fit(train_varnames,train_labels)
    b=time.time()
    print algorithm_name," fitting time:",("{0:.3f}".format(b-a))
    
    #convert predicted labels as a list to compare  
    predict_result= algorithm.predict(test_varnames).tolist()
    c=time.time()
    print algorithm_name," predict time:", ("{0:.3f}".format(c-b))
    accuracy = calculator(predict_result, test_labels)
    print algorithm_name," accuracy:", ("{0:.1f}%".format(accuracy * 100))
    
    limit_accuracies.append((accuracy,scores.mean(),limit))

    return predict_result,accuracy
    
def find_best_limit(limit_accuracies):
          
    max_accuracy = sorted(limit_accuracies,key=operator.itemgetter(0), reverse=True)
    max_mean = sorted(limit_accuracies,key=operator.itemgetter(1), reverse=True)
      
    l_accuracy, l_mean, l_number =  zip(*limit_accuracies) 
    print(l_accuracy,l_mean,l_number)
    print(max_accuracy)
    print(max_mean)
      
    plt.figure(1)
    plt.subplot(211)
    plt.xlabel('Limit of Attributes')
    plt.ylabel('Mean Accuracy on Cross Validation')
    plt.plot(list(l_number),list(l_mean), 'g--')
    plt.axis([0,limit, 0.1, 0.3])
      
    plt.subplot(212)
    plt.xlabel('Limit of Attributes')
    plt.ylabel('Accuracy on Test Data')
    plt.plot(list(l_number),list(l_accuracy), 'g--')
    plt.axis([0,limit, 0.1, 0.3])
      
    plt.savefig('test.png')
    plt.show()


# def get_dataset(data, varnames,new_delete_attributes):
#     delete_index = check_indexes(varnames, new_delete_attributes)
#     for x in range(len(delete_index)):
#         del varnames[delete_index[x]]
#         for y in range(len(data)):
#             del data[y][delete_index[x]]
#             
#     for x in range(len(data)):
#         for y in range(len(data[x])):
#             if not data[x][y]:
#                 data[x][y]=0
#             else:
#                 data[x][y]=float(data[x][y])
#             
#     return data, varnames
#         
    
    
def print_min_max(counter_list,varnames):
    for x in range(len(counter_list)):
        dic = counter_list[x]     
        print varnames[x],':', len(dic)

            
def main(argv):
    if (len(argv) != 2):
        print ('Usage: id3.py <input> <outputcs>')
        sys.exit(2)
        
    #read a file and count the values for each feature
    (data, varnames, counter_list) = read_data(argv[0])
    #print the max value and min value
#     print_min_max(counter_list,varnames) 
#     time.sleep(50)
    #change the regression problem as a classification problem
    predict_transfer(data,varnames.index('imdb_score'))

    #['director_name','actor_2_name','genres','actor_1_name','movie_title','actor_3_name','plot_keywords','movie_imdb_link']
#     delete_attributes=['director_name','actor_2_name','genres','movie_title','actor_3_name','plot_keywords','movie_imdb_link']
    delete_attributes=['color','director_name','actor_2_name','genres','actor_1_name','movie_title','actor_3_name','plot_keywords','movie_imdb_link','language', 'country', 'content_rating']
    
    new_delete_attributes= ['director_name','actor_2_name','actor_1_name','movie_title','actor_3_name','movie_imdb_link']
#     (new_data, new_varnams) = data_transer(data, varnames,counter_list,new_delete_attributes,9000)
#          
#     print "The attribute is extended by:" , set(delete_attributes) - set(new_delete_attributes)
#     run_algorithms(new_data)

    
     
     
    global penalty_list
    penalty_list=[]
    global penalty
    penalty =0
           
          
    #test the number K for the limit of attributes with bags of words
    global limit_accuracies
    limit_accuracies=[]
    global limit
    limit =0
    for x in range(10):
        limit = x*20
        (new_data, new_varnams) = data_transer(data, varnames,counter_list,new_delete_attributes,limit)
        print "The attribute is extended by:" , set(delete_attributes) - set(new_delete_attributes)
        run_algorithms(new_data)   
      
    find_best_limit(limit_accuracies)

#     for x in range(len(delete_attributes)):
#         new_delete_attributes= delete_attributes[:x]+delete_attributes[x+1:]
#         (new_data, new_varnams) = data_transer(data, varnames,counter_list,new_delete_attributes)  
#         print "The attribute is extended by:" , set(delete_attributes) - set(new_delete_attributes)
#         run_algorithms(new_data)
         
    
#     
#     print(varnames[19])
#     keys=counter_list[19].keys()
#     print(keys)
#     for x in range(len(counter_list)):
#         keys=counter_list[x].keys()
#         for y in range(len(keys)):
#             if keys[y]==" ":
#                 print(keys)
    
#     for x in range(len(counter_list)):
#         print(counter_list[x])
#         print(len(counter_list[x]))
#         time.sleep(5)
    
#     print (len(varnames),extend_indexes)
#     for x in extend_indexes:
#         print (varnames[x])
#     print (varnames)
#     print (data[0])
    #convert an array into np.asarray
#     b = np.asarray(data)
#     print(b)
    
    
if __name__ == '__main__':
    main(sys.argv[1:])