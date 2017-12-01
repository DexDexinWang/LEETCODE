/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 9:08:35 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 */

import generator.StringRandom;

public class Solution125 {
	public static void main(String[] args) {
		String input = StringRandom.strAlphabetCapGen(5);
		System.out.println(input);
		System.out.println(isPalindrome(input));
	}
    public static boolean isPalindrome(String s) 
    {
    	if(s.isEmpty()) return true;
    	char[] list = s.toCharArray();
    	int head=0, tail=s.length()-1;
    	char cHead,cTail;
    	while(head<=tail)
    	{
    		cHead=list[head];
    		cTail=list[tail];
    		if(!Character.isLetterOrDigit(cHead))
    		{
    			head++;
    		}
    		else if(!Character.isLetterOrDigit(cTail))
    		{
    			tail--;
    		}
    		else 
    		{
    			if(Character.toLowerCase(cHead)!=Character.toLowerCase(cTail))
    			{
    				return false;
    			}
    			head++;
    			tail--;
    		}
    	}
    	return true;
    }

}
