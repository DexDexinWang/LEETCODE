import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 3, 2017 9:21:19 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */


public class Solution566 {
	public static void main(String[] args) 
	{
		int[][] input = {{1,2},{3,4}};
		int[][] output = matrixReshape(input,1,4);
		System.out.println(Arrays.deepToString(output));
	}
	
    public static int[][] matrixReshape(int[][] nums, int r, int c) 
    {
        int x = nums.length;
        int y = nums[0].length;
        if(x*y!=r*c) return nums;
        int[][] output= new int[r][c];
        for(int i =0; i<r*c; i++)
        {
            output[i/c][i%c] = nums[i/y][i%y];
        }
        return output;
    }

}
