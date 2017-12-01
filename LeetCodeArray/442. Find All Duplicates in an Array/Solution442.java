/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 26, 2017 9:59:03 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of integers, 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import generator.ArrayRandom;

public class Solution442 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(findDuplicates(input));
	}
	public static List<Integer> findDuplicates(int[] nums) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
		{
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0) result.add(Math.abs(index+1));
            nums[index] = -nums[index];
		}
		return result;
	}

}
