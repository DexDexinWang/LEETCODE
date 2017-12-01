/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 10:03:59 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
counting from the start of the string. If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
and left the other as original.
 */
public class Solution541 {

	public static void main(String[] args) {
		String input = "abcdefg";
		System.out.println(input);
		System.out.println(reverseStr(input,8));
	}
	
    public static String reverseStr(String s, int k) 
    {
    	char[] c = s.toCharArray();
    	int i=0,j=k-1;
        while(i<s.length())
        {
        	if (j>=s.length())
        	{
        		swap(c,i,s.length()-1);
        	}
        	else
        	{
        		swap(c,i,j);
        	}
        	i+=2*k;
        	j=i+k-1;
        }
        return new String(c);
    }
    
    private static void swap(char[] c,int i,int j)
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
