/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 27, 2017 10:18:06 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].
 */

import java.util.List;
import java.util.LinkedList;



public class Solution624 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		List<List<Integer>> input = new LinkedList<List<Integer>>();
		System.out.print(maxDistance(input));
	}
	private static int maxDistance(List<List<Integer>> arrays) 
	{
		if(arrays==null || arrays.size()<2) return 0;
		int result = Integer.MIN_VALUE;
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrays.get(0).size()-1);
		
		for(int i =1; i<arrays.size(); i++)
		{
			result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size()-1)-min));
			result = Math.max(result, Math.abs(arrays.get(i).get(0)-max));
			min = Math.min(min, arrays.get(i).get(0));
			max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
		}
		return result;
	}
}
