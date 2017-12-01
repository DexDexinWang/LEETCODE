/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 12:52:39 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
 */

import generator.StringRandom;

public class Solution434 {

	public static void main(String[] args) {
		String input = StringRandom.strAlphabetSpceGen(10);
		System.out.println(input + "\n"+ countSegments(input));
	}
	
    public static int countSegments(String s) {
        if(s.length()==0) return 0;
        int result=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
            {
                result++;
            }
        }
        return result;
    }
}
