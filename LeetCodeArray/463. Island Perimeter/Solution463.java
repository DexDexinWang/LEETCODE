/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 9, 2017 3:15:27 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
 and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" 
 (water inside that isn't connected to the water around the island). One cell is a square with side length 1. 
 The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16

 */

public class Solution463 {

	public static void main(String[] args) 
	{
//		int[][] input={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		int[][] input = {{1},{0}};
		int output = islandPerimeter(input);
		System.out.println(output);
	}
	
    public static int islandPerimeter(int[][] grid) 
    {
    	int perimeter =0;
    	for(int i=0; i<grid.length; i++)
    	{
    		for(int j=0; j<grid[0].length; j++)
    		{
    			
    			if (grid[i][j]==1)
    			{
    				perimeter+=4;
    				if(i>0 && grid[i-1][j]==1)
    				{
    					perimeter -=2;
    				}
    				if(j>0 && grid[i][j-1]==1)
    				{
    					perimeter -=2;
    				}
    			}
    		}
    	}
    	return perimeter;
    }

}
