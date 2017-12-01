/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 10:36:04 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */

import generator.ArrayRandom;

public class Solution38 {

	public static void main(String[] args) 
	{
		int input = ArrayRandom.range();
		System.out.println(input+"\t"+countAndSay(input));
	}
	
    public static String countAndSay(int n) 
    {
        String result="";
        char[] list = Integer.toString(n).toCharArray();
        char pre=list[0];
        int counter = 1;
        for(int i=1; i < list.length; i++)
        {
        	if(list[i]!=pre)
        	{
        		result+= counter+""+pre;
        		counter=1;
        		pre=list[i];
        	}
        	else
        	{
        		counter++;
        	}
        }
        
        return result+= counter+""+pre;
    }

}
