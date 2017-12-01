/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 6:45:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution453 {

	public static void main(String[] args) {
		int[] input =ArrayRandom.arrayGen(3, 0, 4);
		System.out.println(Arrays.toString(input));
		System.out.println(minMoves(input));
	}
	
    public static int minMoves(int[] nums) 
    {
        int min=Integer.MAX_VALUE;
        for (int i: nums)
        {
        	if (min > i)
        	{
        		min = i;
        	}
        }
        
        int result=0;
        for( int i: nums)
        {
        	result += i - min;
        }
        
        return result;
    }

}
