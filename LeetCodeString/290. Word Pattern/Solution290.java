/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 10:17:21 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

import java.util.HashMap;

public class Solution290 {
	public static void main(String[] args) 
	{
		String input1 = "abba";
		String input2 = "dog cat cat dog";
		System.out.println(wordPattern(input1,input2));
	}

    public static boolean wordPattern(String pattern, String str) 
    {
    	String[] list = str.split(" ");
    	HashMap<Character,String> map = new HashMap<Character,String>();
    	if(list.length!=pattern.length())
    	{
    		return false;
    	}
    	for(int i=0; i<list.length; i++)
    	{
    		char c = pattern.charAt(i);
    		if(map.containsKey(c))
    		{
    			if(!map.get(c).equals(list[i]))
    			{
    				return false;
    			}
    		}
    		else 
    		{
    			if(map.containsValue(list[i]))
    			{
    				return false;
    			}
    			else
    			{
    				map.put(c, list[i]);		
    			}
    		}
    	}
    	return true;
    }
	
}
