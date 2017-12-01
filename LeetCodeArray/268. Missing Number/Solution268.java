/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 5:08:59 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 */


public class Solution268 {
	public static void main(String[] args) {
		int[] input = {1,0};
		System.out.println(missingNumber(input));
	}
    public static int missingNumber(int[] nums) 
    {
    	if (nums.length == 0) return -1;
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }

}
