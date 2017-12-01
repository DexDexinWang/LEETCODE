/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 25, 2017 8:48:51 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
 */



public class Solution408 {

	public static void main(String[] args) 
	{
		System.out.println(validWordAbbreviation("internationalization","i12iz4n"));
	}
    public static boolean validWordAbbreviation(String word, String abbr) 
    {
    	int i = 0 ,j=0;
    	while(i < word.length() && j < abbr.length())
    	{
    		if(word.charAt(i)==abbr.charAt(j))
    		{
    			i++;
    			j++;
    			continue;
    		}
    		if(abbr.charAt(j)<='0' || abbr.charAt(j)>'9')
    		{
    			return false;
    		}
    		int start = j;
    		while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9')
    		{
    			j++;
    		}
    		int length= Integer.valueOf(abbr.substring(start, j));
    		i+=length;
    	}
    	return i==word.length() && j==abbr.length();
    }
}
