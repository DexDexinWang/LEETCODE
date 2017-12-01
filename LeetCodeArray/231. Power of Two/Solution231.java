/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 2:44:12 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer, write a function to determine if it is a power of two.
*/

import generator.ArrayRandom;

public class Solution231 {

	public static void main(String[] args) 
	{
		int input = ArrayRandom.range(10, 100);
		System.out.println(input+"\t"+isPowerOfTwo(input));
	}

    public static boolean isPowerOfTwo(int n) 
    {
        return n>0 && Integer.bitCount(n) == 1; 
    }
}
