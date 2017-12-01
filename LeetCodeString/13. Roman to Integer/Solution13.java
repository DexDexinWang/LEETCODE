/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 9:22:16 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/


public class Solution13 {

	public static void main(String[] args) {
		String input = "IVX";
		System.out.println(input);
		System.out.println(romanToInt(input));
	}

    public static int romanToInt(String s) 
    {
    	int[] nums = new int[s.length()];
    	for(int i=0; i<s.length(); i++)
    	{
    		switch(s.charAt(i))
    		{
    			case 'M':
    				nums[i]=1000;
    				break;
    			case 'D':
    				nums[i]=500;
    				break;
    			case 'C':
    				nums[i]=100;
    				break;
    			case 'L':
    				nums[i]=50;
    				break;
    			case 'X':
    				nums[i]=10;
    				break;
    			case 'V':
    				nums[i]=5;
    				break;
    			case 'I':
    				nums[i]=1;
    				break;
    		}
    	}
    	
    	int result=0;
    	for(int i=0; i<nums.length-1; i++)
    	{
    		if(nums[i]<nums[i+1])
    		{
    			result-=nums[i];
    		}
    		else
    		{
    			result+=nums[i];
    		}
    	}
    	return result+nums[nums.length-1];
    }
}
