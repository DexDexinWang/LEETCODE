
/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 2, 2017 12:24:58 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
	public static void main(String[] args) 
	{
		int[] nums= {2, 7, 11, 15};
		int target=9;
		Solution1 so=new Solution1();
		System.out.println(Arrays.toString(so.twoSum(nums, target)));
		
	}
	
	public int[] twoSum(int[] nums, int target) 
	{
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for (int i=0 ; i<nums.length; i++)
		{
			int temp=target-nums[i];
			if (hm.containsKey(temp))
			{
				int[] output={i,hm.get(temp)};
				return output;
			}
			hm.put(nums[i], i);
		}
        return null;
    }
}
