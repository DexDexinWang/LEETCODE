/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 27, 2017 2:03:36 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */

import generator.ArrayRandom;

public class Solution7 {
	public static void main(String[] args) {
		int input= ArrayRandom.range();
		System.out.println(input+"\t"+reverse(input));
	}
	
	private static int reverse(int x) 
    {
        boolean neg=false;
        if(x<0)
        {
            x=-x;
            neg =true;
        }
        long result=0;
        
        while(x!=0)
        {
        	result= result*10+ (x%10);
            x/=10;
            if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        if (neg)
        {
            return -(int)result;
        }
        
        return (int)result;
    }
}
