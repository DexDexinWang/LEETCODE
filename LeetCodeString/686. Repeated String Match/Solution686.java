/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Oct 25, 2017 11:48:12 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (ˇ°abcdabcdabcdˇ±), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */

public class Solution686 {
	public static void main(String[] args) 
	{
		String input1 = "abc";
		String input2 = "dabcabca";
		System.out.println(repeatedStringMatch(input1,input2));
	}
    public static int repeatedStringMatch(String A, String B) 
    {
        int count = 0; 
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length())
        {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }

}
