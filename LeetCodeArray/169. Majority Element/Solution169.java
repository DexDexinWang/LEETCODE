/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 10:52:50 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than  n/2  times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.Arrays;
import java.util.HashMap;
import generator.ArrayRandom;

public class Solution169 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(5, 0, 1);
		System.out.println(Arrays.toString(input));
		System.out.println(majorityElement(input));
	}
	
    public static int majorityElement(int[] nums) 
    {
    	HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
    	for(int i : nums)
    	{
    		if(hs.containsKey(i))
    		{
    			hs.put(i, hs.get(i)+1);
    		}
    		else
    		{
    			hs.put(i, 1);
    		}
    		if(hs.get(i)>(nums.length/2))
    		{
    			return i;
    		}
    	}
    	return -1;
    }
    
    /*Two lines*/
    	/*
    public static int majorityElement(int[] nums) 
    {
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
    */
}
