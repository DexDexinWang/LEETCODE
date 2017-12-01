/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 7:02:22 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a function to find the longest common prefix string amongst an array of strings.
 */

public class Solution14 {
	public static void main(String[] args) 
	{

	}
    public static String longestCommonPrefix(String[] strs) 
    {
    	if(strs==null || strs.length==0) return "";
    	int minLen=Integer.MAX_VALUE;
    	for(String str: strs)
    	{
    		minLen=Math.min(minLen, str.length());
    	}
    	int low=1;
    	int high=minLen;
    	while(low<=high)
    	{
    		int middle=(low+high)/2;
    		if(isCommonPrefix(strs,middle))
    		{
    			low=middle+1;
    		}
    		else
    		{
    			high=middle-1;
    		}
    	}
    	return strs[0].substring(0, (low+high)/2);

    }
    private static boolean isCommonPrefix(String[] strs,int len)
    {
    	String str1=strs[0].substring(0, len);
    	for(int i=1; i<strs.length;i++)
    	{
    		if(!strs[i].startsWith(str1))
    		{
    			return false;
    		}
    	}
    	return true;
    }

}
