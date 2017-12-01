/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 1, 2017 8:46:11 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

import generator.ArrayRandom;

public class Solution400 {
	public static void main(String[] args) {
		int input =ArrayRandom.range();
		System.out.println(input+"\t"+findNthDigit(11));
	}
	
    public static int findNthDigit(int n) 
    {
    	int len=1;
    	long count=9;
    	int start = 1; 
    	while(n>len*count)
    	{
    		n=(int) (n-len*count);
    		len++;
    		count*=10;
    		start*=10;
    	}
    	start = start+(n-1)/len;
    	String s = Integer.toString(start);
    	return Character.getNumericValue(s.charAt((n-1)%len));
    	
    }
	

}
