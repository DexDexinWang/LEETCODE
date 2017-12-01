/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 1:15:37 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution121 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 1, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(maxProfit(input));
	}
	
    public static int maxProfit(int[] prices) 
    {
		if (prices.length==0)
		{
			return 0;
		}
		int max = 0 ;
		int min = prices[0];
		
		for(int i=0; i<prices.length; i++)
		{
			if(prices[i]>min)
			{
				max = Math.max(max, prices[i]- min);
			}
			else
			{
				min = prices[i];
			}
		}
		return max;
    }
	

}
