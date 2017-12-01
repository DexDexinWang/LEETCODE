/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 9:45:55 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution122 {

	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(maxProfit(input));
	}
	
    public static int maxProfit(int[] prices) 
    {
    	int result=0;
    	for(int i=0; i< prices.length; i++)
    	{
    		while (i < prices.length-1 && prices[i] >= prices[i+1])
    		{
    			i++;
    		}
    		int min = prices[i];
    		
    		while(i < prices.length-1 && prices[i] <= prices[i+1])
    		{
    			i++;
    		}
    		result += prices[i]-min;
    	}
    	return result;
    }

}
