/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 24, 2017 6:07:59 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */



/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */

import java.util.List;
import java.util.LinkedList;

public class Solution139 {

	public static void main(String[] args) {
		List<String> input = new LinkedList<String>();
		input.add("leet");
		input.add("code");
		System.out.println(wordBreak("leetcode",input));
	}
	
    public static boolean wordBreak(String s, List<String>dict) 
    {
    	boolean[] f=new boolean[s.length()+1];
    	f[0] = true;
    	
    	for(int i=1;i<=s.length();i++)
    	{
    		for(int j=0;j<i;j++)
    		{
    			if(f[0] && dict.contains(s.substring(j, i)))
    			{
    				f[i]=true;
    				break;
    			}
    		}
    	}
    	return f[s.length()];
    }
}
