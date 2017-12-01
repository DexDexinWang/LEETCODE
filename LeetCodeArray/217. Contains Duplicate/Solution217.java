/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 9:16:09 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

import java.util.Arrays;
import java.util.HashSet;
import generator.ArrayRandom;

public class Solution217 {

	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(5, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(containsDuplicate(input));
	}
	
    public static boolean containsDuplicate(int[] nums) 
    {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i: nums)
    	{
    		if(!set.add(i))
    		{
    			return true;
    		}
    	}
    	return false;
    }

}
