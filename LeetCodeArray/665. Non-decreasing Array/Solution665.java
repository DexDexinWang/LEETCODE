/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Oct 25, 2017 10:46:49 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 
4
 to 
1
 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
*/
public class Solution665 {
	public static void main(String[] args) 
	{
		int[] input = {4,2,1};
		System.out.print(checkPossibility(input));
	}
	
    public static boolean checkPossibility(int[] nums) {
        int counter = 0 ; 
        for(int i = 1; i< nums.length && counter<=1; i++)
        {
            if(nums[i-1]>nums[i])
            {
                counter++;
                if(i-2<0 || nums[i-2]<=nums[i])
                {
                	nums[i-1] = nums[i];
                }
                else
                {
                	nums[i]= nums[i-1];
                }
            }
        }
        return counter>1? false: true;
    }
}
