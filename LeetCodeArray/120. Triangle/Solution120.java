/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 24, 2017 4:02:14 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.List;
import java.util.LinkedList;

public class Solution120 {
	public static void main(String[] args) 
	{
		List<List<Integer>> input = new LinkedList<List<Integer>>();
		System.out.println(minimumTotal(input));
	}
	
    public static int minimumTotal(List<List<Integer>> triangle) 
    {
    	int[] dp = new int[triangle.size()];
    	for(int i=triangle.size()-1; i>=0; i--)
    	{
    		for(int j=0;j<triangle.get(i).size();j++)
    		{
    			dp[j]=Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
    		}
    	}
    	return dp[0];
    }
}
