/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 10:50:43 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

import generator.StringRandom;

public class Solution459 {

	public static void main(String[] args) 
	{
		String input = StringRandom.strAlphabetGen(5);
		System.out.println(input);
		System.out.println(repeatedSubstringPattern(input));
	}

    public static boolean repeatedSubstringPattern(String s) 
    {
        int l = s.length();
        for(int i=l/2; i>=1; i--)
        {
        	if(l%i==0)
        	{
        		int m=l/i;
        		String subS = s.substring(0, i);
        		StringBuilder sb = new StringBuilder();
        		for(int j=0;j<m;j++)
        		{
        			sb.append(subS);
        		}
        		if(sb.toString().equals(s)) return true;
        	}
        }
        return false;
    }
}
