/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 6:49:51 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has 
(also known as the Hamming weight).

For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011, 
so the function should return 3.
 */

import generator.IntegerRandom;

public class Solution191 {

	public static void main(String[] args) {
		int input = IntegerRandom.range();
		System.out.println(Integer.toBinaryString(input)+"\t"+hammingWeight(input));
	}
	
    public static int hammingWeight(int n) 
    {
    	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
    }

}
