/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 11:15:56 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
 */

public class Solution504 {

	public static void main(String[] args) 
	{
		int input = 100;
		System.out.println(convertToBase7(input));
	}
	
    public static String convertToBase7(int num) 
    {
    	/*  return Integer.toString(num, 7); */	
    	if(num<0)
    	{
    		return "-" + convertToBase7(-num);
    	}
    	if(num<7)
    	{
    		return num+""; 
    	}
    	return convertToBase7(num/7) + num%7;
    }

}
