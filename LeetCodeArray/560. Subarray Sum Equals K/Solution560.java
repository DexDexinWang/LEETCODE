/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 26, 2017 9:26:03 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 */

import java.util.Arrays;
import java.util.HashMap;
import generator.ArrayRandom;

public class Solution560 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(subarraySum(input,10));
	}

    public static int subarraySum(int[] nums, int k) 
    {
    	int sum=0,result=0;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	map.put(0, 1);
    	for(int i =0; i< nums.length; i++)
    	{
    		sum+=nums[i];
    		if(map.containsKey(sum-k))
    		{
    			result+=map.get(sum-k);
    		}
    		map.put(sum, map.getOrDefault(sum, 0)+1);
    	}
    	return result;
    }
    
}
