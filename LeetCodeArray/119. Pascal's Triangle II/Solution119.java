/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 8:54:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 */

import java.util.ArrayList;
import java.util.List;

import generator.ArrayRandom;

public class Solution119 {
	public static void main(String[] args) {
		int input = ArrayRandom.range(4, 4);
		List<Integer> result = getRow(input);
		System.out.println(input+"\t"+result.toString());
	}
	
    public static List<Integer> getRow(int rowIndex) 
    {
		List<Integer> result= new ArrayList<Integer>();
		
		for(int i = 0 ; i<rowIndex+1; i++)
		{
			result.add(1);
			for(int j=i-1; j>0;j--)
			{
				result.set(j, result.get(j-1)+result.get(j));
			}
		}
		return result;
    }

}
