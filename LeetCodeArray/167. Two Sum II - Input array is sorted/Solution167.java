import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 1:06:07 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

public class Solution167 {
	public static void main(String[] args) 
	{
		int[] input = new int[]{2, 7, 11, 15};
		int target = 9;
		System.out.print(Arrays.toString(twoSum(input,target)));
	}
	
    public static int[] twoSum(int[] numbers, int target) 
    {
    	int[] result = new int[2];
    	if(numbers.length<2)
    	{
    		return result;
    	}
    	int left = 0;
    	int right = numbers.length-1;

    	while(left < right)
    	{
    		int v = numbers[left] + numbers[right];
    		
    		if ( v == target)
    		{
    			result[0] = left + 1;
    			result[1] = right + 1;
    			break;
    		}
    		else if (v > target)
    		{
    			right --;
    		}
    		else
    		{
    			left++;
    		}
    	}
    	return result;
    }

}
