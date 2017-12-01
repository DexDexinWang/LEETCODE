/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 8:56:52 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */


public class Solution58 {
	public static void main(String[] args) {
		String input = " ";//StringRandom.strAlphabetSpceGen(10);
		System.out.println(input+"\n"+lengthOfLastWord(input));
	}
	
    public static int lengthOfLastWord(String s) 
    {
    	if(s.length()==0) return 0;
    	int i=s.length()-1;
    	while(s.charAt(i)==' ' && i>0)
    	{
    		i--;
    	}
    	int length=i+1;
    	
    	
    	while(i>=0 && s.charAt(i)!=' ')
    	{
    		i--;
    	}
    	return length-1-i;
    }

}
