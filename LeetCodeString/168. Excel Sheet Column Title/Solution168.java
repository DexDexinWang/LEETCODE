/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 1, 2017 9:24:45 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class Solution168 {
	public static void main(String[] args) 
	{
		System.out.println(convertToTitle(27));
	}
	
	private static String convertToTitle(int n) 
	{
        return n==0 ? "" : convertToTitle(--n/26)+(char)('A'+(n%26));
	}

}
