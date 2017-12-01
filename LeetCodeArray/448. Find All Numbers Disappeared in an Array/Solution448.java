/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 12:18:45 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Given an array of integers where 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import generator.ArrayRandom;

public class Solution448 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(8,1,6);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(findDisappearedNumbers(input).toArray()));
	}
	
    public static List<Integer> findDisappearedNumbers(int[] nums) 
    {
    	List<Integer> result =new ArrayList<Integer>();
    	
    	for(int i = 0; i<nums.length; i++)
    	{
    		int position = Math.abs(nums[i])-1;
    		if(nums[position]>0)
    		{
    			nums[position] = -nums[position];  
    		}
    	}
    	
    	for(int i=0; i< nums.length; i++)
    	{
    		if(nums[i]>0)
    		{
    			result.add(i+1);
    		}
    	}
    	
    	return result;
    }

}
