/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 10:24:21 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */

import generator.StringRandom;
public class Solution171 {


	public static void main(String[] args) 
	{
		String input = StringRandom.strAlphabetCapGen(1);
		System.out.println(input);
		System.out.println(titleToNumber(input));
	}

	//use ASCII table to sovle it.
    public static int titleToNumber(String s) 
    {
    	int result=0;
    	for(int i=0; i< s.length(); i++)
    	{
    		result=(int)s.charAt(i) - 64 + result*26;
    	}
    	return result;
    }
}
