/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 7:22:30 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import generator.ArrayRandom;

public class Solution118 {
	public static void main(String[] args) 
	{
		int input = ArrayRandom.range(0,5);
		System.out.println(input);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for(int i=0; i< output.size(); i++)
		{
			System.out.println(Arrays.toString(output.get(i).toArray()));
		}
	}
	
    public static List<List<Integer>> generate(int numRows) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int i=0; i<numRows;i++)
    	{
    		List<Integer> line =new ArrayList<Integer>();
    		for(int j=0; j<i+1; j++)
    		{
    			if(j==0 || j==i)
    			{
    				line.add(1);
    			}
    			else
    			{
    				line.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
    			}
    		}
    		result.add(line);
    	}
    	return result;
    }
	

}
