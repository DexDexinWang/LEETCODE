/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 10:16:53 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
*/

import generator.StringRandom;

public class Solution557 {

	public static void main(String[] args) 
	{
		String input = StringRandom.strAlphabetSpceGen(5);
		System.out.println(input);
		System.out.println(reverseWords(input));
	}
    public static String reverseWords(String s) 
    {
    	char[] c = s.toCharArray();
    	for(int i=0; i<c.length; i++)
    	{
    		if(c[i]!=' ')
    		{
    			int j = i;
    			while(j+1<c.length && c[j+1]!=' ')
    			{
    				j++;
    			}
    			reverse(c, i , j);
    			i=j;
    		}
    	}
    	return new String(c);
    }
    
    private static void reverse(char[] c, int i , int j)
    {
    	while(i<j)
    	{
    		char temp =c[i];
    		c[i] = c[j];
    		c[j] = temp;
    		i++;
    		j--;
    	}
    }
	

}
