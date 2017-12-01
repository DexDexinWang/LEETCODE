/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 4:00:33 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

*/

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution283 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(5, 0, 5);
		System.out.println(Arrays.toString(input));
		moveZeroes(input);
		System.out.println("------------split---------");
		System.out.println(Arrays.toString(input));
	}
	
    public static void moveZeroes(int[] nums) 
    {    
    	for(int i=0,j=0; i<nums.length; i++)
    	{
    		if(nums[i]!=0)
    		{
    			int temp =nums[i];
    			nums[i]=nums[j];
    			nums[j]=temp;
    			j++;
    		}
    	}
    }

}
