/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 8:29:04 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/ 

import generator.StringRandom;
public class Solution409 {
	public static void main(String[] args) {
		String input = StringRandom.strAlphabetSmaGen(10);
		System.out.println(input);
		System.out.println(longestPalindrome(input));
	}
	
    public static int longestPalindrome(String s) 
    {
    	int[] counter= new int[52];
    	for(int i=0; i<s.length();i++)
    	{
    		if(Character.isUpperCase(s.charAt(i)))
    		{
    			counter[s.charAt(i)-'A']++;
    		}
    		else
    		{
    			counter[s.charAt(i)-'a'+26]++;
    		}
    		
    	}
    	
    	int result=0;
    	for(int i=0; i<counter.length; i++)
    	{
    		if(counter[i] >1)
    		{
    			result += counter[i]/2; 
    		}
    	}
    	if(result*2 == s.length())
    	{
    		return result*2;
    	}
    	else
    	{
    		return result*2+1;
    	}
    }
}
