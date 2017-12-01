import java.util.Arrays;

import generator.ArrayRandom;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Oct 26, 2017 11:12:03 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses 
remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum 
amount of money you can rob tonight without alerting the police.
 */

public class Solution213 
{
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 1, 100);
		System.out.println(Arrays.toString(input)+ "\n"+rob(input));
	}
	
    public static int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];
       return Math.max(helpRob(nums,0, nums.length-1), helpRob(nums,1,nums.length));
    }
    
    private static int helpRob(int[] nums, int begin, int end)
    {
        int preRob=0;
        int preRobNo=0;
        for(int i=begin; i<end; i++)
        {
            int temp = preRobNo;
            preRobNo = Math.max(preRobNo,preRob);
            preRob = nums[i]+temp;
        }
        return Math.max(preRobNo,preRob);
    }
}
