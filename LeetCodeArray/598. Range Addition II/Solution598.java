/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 10:43:21 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input: 
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation: 
Initially, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.
Note:
 */

public class Solution598 {
	public static void main(String[] args) 
	{
		int[][] input =new int[3][3];
		System.out.println(maxCount(4,4,input));
	}

    public static int maxCount(int m, int n, int[][] ops) 
    {
    	if(ops==null ||ops.length==0) return n*m;
    	int row = Integer.MAX_VALUE; 
    	int col = Integer.MAX_VALUE;
    	for(int[] i:ops)
    	{
    		row=Math.min(row, i[0]);
    		col=Math.min(col, i[1]);
    	}
    	return row*col;
    }
}
