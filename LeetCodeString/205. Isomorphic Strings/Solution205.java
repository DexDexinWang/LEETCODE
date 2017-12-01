
/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 11:55:30 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 */

import generator.StringRandom;

public class Solution205 {
	public static void main(String[] args) 
	{
		String input1 = StringRandom.strAlphabetGen(5);
		String input2 = StringRandom.strAlphabetGen(5);
		System.out.println(input1+"\t"+input2+"\t"+isIsomorphic(input1,input2));
	}
	
    public static boolean isIsomorphic(String s, String t) {
    	char[] sList = s.toCharArray();
    	char[] tList = t.toCharArray();
    	if(sList.length!=tList.length) return false;
    	char[] sTemp = new char[256];
    	char[] tTemp = new char[256];
    	for(int i=0;i<sList.length;i++)
    	{
    		char sc=sList[i];
    		char tc=tList[i];
    		if(sTemp[sc]==0 && tTemp[tc]==0)
    		{
    			sTemp[sc]=tc;
    			tTemp[tc]=sc;
    		}
    		else
    		{
    			if(sTemp[sc]!=tc || tTemp[tc]!=sc)
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }

}
