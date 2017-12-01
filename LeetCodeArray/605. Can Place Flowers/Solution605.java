/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 8, 2017 6:25:17 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Suppose you have a long flower bed in which some of the plots 
are planted and some are not. However, flowers cannot be planted 
in adjacent plots - they would compete for water and both would die.

Given a flowered (represented as an array containing 0 and 1, where 
0 means empty and 1 means not empty), and a number n, return if n new 
flowers can be planted in it without violating the no-adjacent-flowers rule.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution605 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 1);
		System.out.println(Arrays.toString(input));
		System.out.println(canPlaceFlowers(input,2));
	}
	
    public static boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
    	int count=0;
    	int length = flowerbed.length;
    	for(int i=0; i<length && count<n; i++)
    	{
    		if(flowerbed[i]==0)
    		{
    			int next = (i==length-1) ? 0 : flowerbed[i+1];
    			int prev = (i==0) ? 0 : flowerbed[i-1];
    			if(next==0 && prev==0)
    			{
    				flowerbed[i]=1;
    				count++;
    			}
    		}
    	}
    	return count == n;
    } 

}
