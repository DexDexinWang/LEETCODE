/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 7:12:23 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/


public class Solution383 {
	public static void main(String[] args) 
	{
		String input1 = "a";
		String input2 =  "b";
		System.out.println(input1 +"\t"+ input2);
		System.out.println(canConstruct(input1,input2));
	}
	
    public static boolean canConstruct(String ransomNote, String magazine) 
    {
    	int[] counter= new int[26];
    	for(int i = 0 ; i< magazine.length() ; i++)
    	{
    		counter[magazine.charAt(i)-'a']++;
    	}
    	
    	for(int i= 0; i< ransomNote.length(); i++)
    	{
    		if(--counter[ransomNote.charAt(i)-'a'] <0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
	
}
