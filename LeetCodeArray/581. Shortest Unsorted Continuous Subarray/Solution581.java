/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 26, 2017 8:24:24 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */

import java.util.Arrays;
import generator.ArrayRandom;

public class Solution581 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 100);
		System.out.println(Arrays.toString(input));
		System.out.println(findUnsortedSubarray(input));
	}
	
    public static int findUnsortedSubarray(int[] nums) 
    {
        int n=nums.length, beg=-1, end=-2, min=nums[n-1],max=nums[0];
        for(int i =1; i <n ; i++)
        {
            max = Math.max(max,nums[i]);
            if(nums[i]<max) end = i;
            min = Math.min(min,nums[n-1-i]);
            if(nums[n-1-i]>min) beg = n-1-i;
        }
        return end-beg+1;
    }

}
