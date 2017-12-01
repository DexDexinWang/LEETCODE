/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 9, 2017 1:52:28 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1¡¯s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import generator.ArrayRandom; 

public class Solution496
{
	public static void main(String[] args) 
	{
		int[] nums1=ArrayRandom.arrayGenNoDuplication(5, 1, 10);
		int[] nums2=ArrayRandom.subarrayGen(nums1);
		
		System.out.println(Arrays.toString(nums1));
		System.out.println("------------------Split-----------------");
		System.out.println(Arrays.toString(nums2));
		System.out.println("------------------result-----------------");
		
		int[] output = nextGreaterElement(nums2, nums1);
		System.out.println(Arrays.toString(output));

	}
	
    public static int[] nextGreaterElement(int[] findNums, int[] nums) 
    {
    	HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
    	Stack<Integer> stack =new Stack<Integer>();
    	for(int i: nums)
    	{
    		while(!stack.isEmpty() && stack.peek() < i)
    		{
    			map.put(stack.pop(), i);
    		}
    		stack.push(i);
    	}
    	int[] result =new int[findNums.length];
    	for(int i=0; i<findNums.length; i++)
    	{
    		result[i] = map.getOrDefault(findNums[i], -1);
    	}
    	return result;
    }

}
