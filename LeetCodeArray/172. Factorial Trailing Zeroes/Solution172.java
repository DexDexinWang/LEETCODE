/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 9:15:52 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer n, return the number of trailing zeroes in n!.
 */

import generator.ArrayRandom;

public class Solution172 {
	public static void main(String[] args) {
		int input = ArrayRandom.range();
		System.out.println(input+"\t"+trailingZeroes(input));
	}

    public static int trailingZeroes(int n) 
    {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
