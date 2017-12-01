/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 9:36:07 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution350 {

	public static void main(String[] args) {
		int[] input1 = {1,2,2,1};
		int[] input2 = {2,2};
		System.out.println(Arrays.toString(intersect(input1,input2)));
	}
	
    public static int[] intersect(int[] nums1, int[] nums2) 
    {
    	HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
        for(int i: nums1)
        {
        	if(counter.containsKey(i))
        	{
        		counter.put(i, counter.get(i)+1);
        	}
        	else
        	{
        		counter.put(i, 1);
        	}
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i:nums2)
        {
        	if(counter.containsKey(i) && counter.get(i)>0)
        	{
        		counter.put(i, counter.get(i)-1);
        		temp.add(i);
        	}
        }
        
        int[] result = new int[temp.size()];
        for(int i=0; i< temp.size(); i++)
        {
        	result[i]=temp.get(i);
        }
        return result;
    }

}
