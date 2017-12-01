/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 10:17:20 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

class MovingAverage {
    int s=0;
    double[] space;
    int count=0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        space = new double[size];
        s=size;
    }
    
    public double next(int val) {
        space[count%s]=val;
        count++;
        double sum=0;
        for(int i=0;i<s;i++)
        {
            sum+=space[i];
        }
        if(count<s) return sum/count;
        return sum/s;
    }
}