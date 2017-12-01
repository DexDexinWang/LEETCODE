/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Oct 27, 2017 12:25:49 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = ¡°eceba¡± and k = 2,

T is "ece" which its length is 3.


 */

public class Solution340 {
	public static void main(String[] args) 
	{
		String input = "eceba";
		System.out.print(lengthOfLongestSubstringKDistinct(input,2));
	}
	
    public static int lengthOfLongestSubstringKDistinct(String s, int k)
    {
    	int[] count = new int[256];
    	int res = 0;
    	int i =0;
    	int num = 0;
    	
    	for(int j=0; j<s.length(); j++)
    	{
    		if(count[s.charAt(j)]++ == 0) num++;
    		
    		while(num>k && i<s.length())
    		{
    			count[s.charAt(i)]--;
    			if(count[s.charAt(i)]==0)
    			{
    				num--;
    			}
    			i++;
    		}
    		res = Math.max(res, j-i+1);
    	}
    	return res;
    }

}
