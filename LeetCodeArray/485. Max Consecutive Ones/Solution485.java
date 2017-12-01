/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 9, 2017 5:44:45 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution485 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(5, 0, 1);
		System.out.println(Arrays.toString(input));
	}
    public static int findMaxConsecutiveOnes(int[] nums) 
    {
    	int counter=0;
    	int lastMax=0;
    	for(int i=0; i<nums.length; i++)
    	{
    		if (nums[i]==1)
    		{
    			counter++;
    		}
    		else
    		{
    			if(counter>lastMax)
    			{
    				lastMax=counter;
    			}
    			counter=0;
    		}
    	}
    	
    	if(counter>lastMax)
    	{
    		return counter;
    	}
    	else
    	{
    		return lastMax;
    	}
    }
}
