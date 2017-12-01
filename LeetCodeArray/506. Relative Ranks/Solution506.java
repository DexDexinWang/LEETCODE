/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 8:55:30 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

 */

import java.util.Arrays;
import java.util.HashMap;
import generator.ArrayRandom;

public class Solution506 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGenNoDuplication(100, 0, 1000);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(findRelativeRanks(input)));
	}
	
    public static String[] findRelativeRanks(int[] nums) 
    {
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	for(int i=0; i < nums.length; i++)
    	{
    		hm.put(nums[i], i);
    	}
    	Arrays.sort(nums);
    	String[] result = new String[nums.length];
    	for(int i=0; i < nums.length; i++)
    	{
    		if (i == nums.length-1)
    	    	result[hm.get(nums[i])] = "Gold Medal";
    	    else if (i == nums.length-2)
    	    	result[hm.get(nums[i])] = "Silver Medal";
    	    else if (i == nums.length-3)
    	    	result[hm.get(nums[i])] = "Bronze Medal";
    	    else
    	        result[hm.get(nums[i])] = (nums.length - i)+"";
    	}

    	return result;
    	
    }

}
