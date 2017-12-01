/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 9:36:30 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4.
 */

import java.util.Arrays;
import generator.ArrayRandom;

public class Solution561 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 100);
		System.out.println(Arrays.toString(input));
		System.out.println(arrayPairSum(input));
	}

    public static int arrayPairSum(int[] nums) 
    {
    	Arrays.sort(nums);
    	int result = 0;
    	for(int i =0; i<nums.length; i=i+2)
    	{
    		result += nums[i];
    	}
    	return result;
    }

}
