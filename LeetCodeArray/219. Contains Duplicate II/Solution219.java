/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 11:11:39 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */

import java.util.Arrays;
import generator.ArrayRandom; 
import java.util.HashSet;

public class Solution219 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(containsNearbyDuplicate(input,5));
	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) 
    {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0; i<nums.length;i++)
    	{
    		if(i>k) set.remove(nums[i-k-1]);
    		if(!set.add(nums[i])) return true;
    	}
    	return false;
    }

}
