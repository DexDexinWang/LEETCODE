import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution5225 {

	public static void main(String[] args) {
		int[] input = new int[]{10,2,8,9,3,8,1,5,2,3,7,6};
		Solution5225 test = new Solution5225();
		System.out.println(test.maxEqualFreq(input));
	}
	
    public int maxEqualFreq(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        Map<Integer,Integer> counter = new HashMap<>();
        for(int num: nums) {
            counter.put(num, counter.getOrDefault(num,0) + 1);
        }
        
        Map<Integer, Integer> total = new HashMap<>();
        Set<Integer> appearsSet = new HashSet<Integer>();
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
        	int shows = entry.getValue();
            total.put(shows, total.getOrDefault(shows,0) + 1);
            appearsSet.add(shows);
        }
        List<Integer> appears = new LinkedList<>(); 
        for(int number: appearsSet) {
        	appears.add(number);
        }
        appears.sort((x,y)-> (y - x));
        
        if (total.size() == 1) {
        	int maxShows = appears.get(0);
        	int counters = total.get(maxShows);
        	counters--;
        	return counters * maxShows + 1;
        }
        
        int maxPossible = 0;
        int counter1 = 0;
        
        for(int i = 0; i < appears.size(); i++) {
        	int appear = appears.get(i);
        	counter1 += total.get(appear);
        	if (maxPossible < counter1 * appear) {
        		maxPossible = counter1 * appear;
        	}
        }
        return maxPossible + 1;
    }
    
    class Solution {
    	
        public int maxEqualFreq(int[] nums) {
            HashMap<Integer, Integer> count = new HashMap<>();
            HashMap<Integer,Integer> freq = new HashMap<>();
            int res = 0;
            for(int i = 0; i< nums.length; ++i){
                int num = nums[i];
                int oldfreq = 0;
                // int newfreq = 1;
                if(count.containsKey(num)){
                              oldfreq = count.get(num);
                    count.put(num, oldfreq + 1);
                } else {
         
                    count.put(num , 1);
                }
                
                if(freq.containsKey(oldfreq)){
                    int f = freq.get(oldfreq);
                    if(f == 1){
                        freq.remove(oldfreq);
                    } else {
                        freq.put(oldfreq, f - 1);
                    }
                }
                
                if(freq.containsKey(oldfreq + 1)){
                    freq.put(oldfreq + 1, freq.get(oldfreq + 1) + 1);
                } else {
                    freq.put(oldfreq + 1, 1);
                }
                if(freq.size() == 2){
                    Iterator<Map.Entry<Integer,Integer>> it  =  freq.entrySet().iterator();
                    Map.Entry<Integer,Integer> a = it.next();
                    int aKey = a.getKey();
                    int aValue = a.getValue();
                    Map.Entry<Integer,Integer> b = it.next();
                    int bKey = b.getKey();
                    int bValue = b.getValue();
                    // System.out.printf("%d %d %d %d\n",aKey,aValue, bKey, bValue);
                    if((aKey == 1 && aValue == 1) || (bKey == 1 && bValue == 1) || (aKey == bKey -1 && bValue == 1) || (aKey == bKey +1 && aValue == 1)){
                        res = Math.max(res, i);
                    }
                }  else if(count.size() == 1){
                    res = Math.max(res,i);
                }   else if(freq.size() == 1){
                    if(freq.containsKey(1)){
                        res = Math.max(i,res);
                    }
                }
            }
            return res + 1;
        }
    }
}
