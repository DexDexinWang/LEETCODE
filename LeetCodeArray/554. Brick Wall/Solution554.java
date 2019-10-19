import java.util.List;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 28, 2017 10:01:17 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:
Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
 */

import java.util.HashMap;

public class Solution554 {
	public static void main(String[] args) {
		
	}
	
    public static int leastBricks(List<List<Integer>> wall) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (List < Integer > row: wall) 
        {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) 
            {
                sum += row.get(i);
        		map.put(sum,map.getOrDefault(sum, 0)+1);

            }
        }

        int result=0;
        for(int key:map.keySet())
        {
        	result = Math.max(result, map.get(key));
        }
        return wall.size()-result;
    }

}