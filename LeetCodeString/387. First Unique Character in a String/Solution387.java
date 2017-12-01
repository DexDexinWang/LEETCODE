/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 8:41:19 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */


public class Solution387 {

	public static void main(String[] args) 
	{
		String input = "leetcode";
		System.out.println(firstUniqChar(input));
	}

    public static int firstUniqChar(String s) 
    {
    	int[] counter = new int[26];
    	for(int i=0; i<s.length(); i++)
    	{
    		counter[s.charAt(i)-'a']++;
    	}
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		if (counter[s.charAt(i)-'a']==1)
    		{
    			return i;
    		}
    	}
    	return -1;
    }
}
