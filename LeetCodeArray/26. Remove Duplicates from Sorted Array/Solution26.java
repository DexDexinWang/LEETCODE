/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 6:54:34 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */

public class Solution26 {
	public static void main(String[] args) 
	{
		int[] input = {1,2,3,4,5,6,7,7,8,9};
		System.out.println(removeDuplicates(input));
	}
	
    private static int removeDuplicates(int[] nums) 
    {
    	int i= 0;
        for(int n: nums)
        {
        	if(i==0 || n > nums[i-1])
        	{
        		nums[i++] = n;
        	}
        }
        return i;
    }    

}
