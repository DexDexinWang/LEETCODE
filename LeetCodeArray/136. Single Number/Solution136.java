/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 9, 2017 6:04:05 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution136 {

	public static void main(String[] args) 
	{
		int[] input = {1,2,2};
		System.out.println(singleNumber(input));
	}
	
	/*Solve it with XOR function. 1 XOR 1 XOR 2 = 2*/
    public static int singleNumber(int[] nums) 
    {
    	int result=0;
        for(int i=0; i<nums.length; i++)
        {
        	result ^=nums[i];
        }
        return result;
    }

}
