/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 12:19:18 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution27 {
	public static void main(String[] args) 
	{
		int[] input ={4,5};
		int a= ArrayRandom.range(0, 10);
		System.out.println(Arrays.toString(input) + "\t"+a);
		System.out.println(removeElement(input,5));
	}
	
    public static int removeElement(int[] nums, int val) 
    {
    	int j=nums.length;
    	for(int i=0; i<j; i++)
    	{
    		while(nums[i]==val && i<j)
    		{
    			nums[i]=nums[--j];
    		}
    	}
    	return j;
    }

}
