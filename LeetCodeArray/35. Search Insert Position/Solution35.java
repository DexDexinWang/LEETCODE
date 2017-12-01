/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 2:57:19 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0
 */

import java.util.Arrays;
import generator.ArrayRandom;


public class Solution35 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10);
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		int a = ArrayRandom.range();
		System.out.println(a);

		System.out.println(searchInsert(input,a));
	}
	
    public static int searchInsert(int[] nums, int target) 
    {
       int low = 0 , high = nums.length-1; 
       while(low <= high)
       {
    	   int mid = (low+high)/2;
    	   if(nums[mid]==target)
    	   {
    		   return mid;
    	   }
    	   else if(nums[mid]>target)
    	   {
    		   high =mid-1;
    	   }
    	   else
    	   {
    		   low = mid + 1;
    	   }
       }
       return low;
    }

}
