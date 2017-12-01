/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 11:03:17 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have security 
system connected and it will automatically contact the police if two adjacent 
houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution198 {

	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 1, 100);
		System.out.println(Arrays.toString(input)+ "\n"+rob(input));
	}
	
    public static int rob(int[] nums) 
    {
    	int robPre=0;
    	int robPreNot=0;
    	for(int i=0; i< nums.length; i++)
    	{
    		int robCur = robPreNot + nums[i];
    		int robCurNot = Math.max(robPreNot, robPre);
    		
    		robPreNot = robCurNot;
    		robPre = robCur;
    	}
    	return Math.max(robPre, robPreNot);
    }

}
