/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 11:07:59 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution242 
{
	public static void main(String[] args) 
	{
		String input1 = "anagram";
		String input2 = "nagaram";
		
		System.out.println(isAnagram(input1,input2));
	}
	
    public static boolean isAnagram(String s, String t) 
    {
    	if(s.length()!=t.length())
    	{
    		return false;
    	}
    	int[] counter= new int[26];
    	for(int i=0; i<s.length(); i++)
    	{
    		counter[s.charAt(i)-'a']++;
    	}
    	for(int i=0; i<t.length(); i++)
    	{
    		if(--counter[t.charAt(i)-'a']<0)
    		{
    			return false;
    		}
    	}
    	return true;
    }

}
