/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 7:38:23 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class Solution349 {
	
	public static void main(String[] args) 
	{
		int[] input1 = {1};
		int[] input2 = {1,1};
		System.out.println(Arrays.toString(intersection(input1,input2)));
	}
	
    public static int[] intersection(int[] nums1, int[] nums2) 
    {
    	Set<Integer> temp1 =new HashSet<>();
    	Set<Integer> temp2 =new HashSet<>();
    	
    	for(int i: nums1)
    	{
    		temp1.add(i);
    	}
    	for(int i: nums2)
    	{
    		if(temp1.contains(i))
    		{
    			temp2.add(i);
    		}
    	}
    	
    	int[] result = new int[temp2.size()];
    	int x=0;
    	for(int i: temp2)
    	{
    		result[x++]= i;
    	}
    	return result;
    } 
    
    public static int[] intersection2(int[] nums1, int[] nums2) 
    {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	Set<Integer> tempSet = new HashSet<>();
    	int i = 0;
    	int j = 0;
    	while (i < nums1.length && j < nums2.length) {
    		if (nums1[i] == nums2[j]) {
    			tempSet.add(nums1[i]);
    			i++;
    			j++;
    		} else if (nums1[i] < nums2[j]) {
    			i++;
    		} else {
    			j++;
    		}
    	}
    	int[] result = new int[tempSet.size()];
    	int x=0;
    	for(int k: tempSet)
    	{
    		result[x++]= k;
    	}
    	return result;
    }

}
