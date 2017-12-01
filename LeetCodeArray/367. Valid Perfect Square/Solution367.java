/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 8:10:04 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */

import generator.ArrayRandom;

public class Solution367 {
	public static void main(String[] args) {
		int input = ArrayRandom.range(1,9);
		System.out.println(input+"\t"+isPerfectSquare(input));
	}
	
	/* Newton Method*/
    public static boolean isPerfectSquare(int num) 
    {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

}
