/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 26, 2017 5:07:01 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution628 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(5, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(maximumProduct(input));
	}
	
    public static int maximumProduct(int[] nums) 
    {
    	if(nums==null || nums.length==0) return 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        for(int n: nums)
        {
        	if(n>max1)
        	{
        		max3=max2;
        		max2=max1;
        		max1=n;
        	}
        	else if(n>max2)
        	{
        		max3=max2;
        		max2=n;
        	}
        	else if(n>max3)
        	{
        		max3=n;
        	}
        	
        	if(n<min1)
        	{
        		min2=min1;
        		min1=n;
        	}else if(n<min2)
        	{
        		min2=n;
        	}
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }

}
