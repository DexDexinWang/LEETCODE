/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 7:48:33 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution66 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(1, 0, 0);
		System.out.println(Arrays.toString(input));
		int[] output = plusOne(input);
		System.out.println(Arrays.toString(output));
	}
	
    public static int[] plusOne(int[] digits) 
    {
    	for(int i = digits.length-1; i>=0; i--)
    	{
    		if(digits[i]<9)
    		{
    			digits[i]+=1;
    			return digits;
    		}
    		digits[i]=0;
    	}
    	int[] res = new int[digits.length+1];
    	res[0]=1;
    	return res;
    }

}
