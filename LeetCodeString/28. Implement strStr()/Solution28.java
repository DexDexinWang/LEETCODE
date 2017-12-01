/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 9:25:57 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.StringRandom;

public class Solution28 {
	public static void main(String[] args) 
	{
		String input1 = StringRandom.strAlphabetCapGen(5);
		System.out.println(input1);
		String input2 = StringRandom.strAlphabetCapGen(1);
		System.out.println(input2);
		System.out.println(strStr(input1,input2));
	}

    public static int strStr(String haystack, String needle) 
    {
    	  for (int i = 0; ; i++) 
    	  {
    		    for (int j = 0; ; j++) 
    		    {
    		    	if (j == needle.length()) return i;
    		    	if (i + j == haystack.length()) return -1;
    		    	if (needle.charAt(j) != haystack.charAt(i + j)) break;
    		    }
    	  }
    }
}
