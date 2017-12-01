/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 8:13:24 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Input: x = 1, y = 4
Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ¡ü   ¡ü
The above arrows point to positions where the corresponding bits are different.
*/

import generator.IntegerRandom;

public class Solution461 
{

	public static void main(String[] args) 
	{
		int x = IntegerRandom.range(1,100);
		int y = IntegerRandom.range(1,100);
		System.out.println(x+"\t"+y);
		System.out.println(Integer.toBinaryString(x)+"\t"+ Integer.toBinaryString(y));
		System.out.println("x^y:\t"+ (x^y));
		System.out.println("x^y:\t"+ Integer.toBinaryString(x^y));
		int result = hammingDistance(x,y);
		System.out.println("The hamming distance is: \t"+result);
	}
	
    public static int hammingDistance(int x, int y) 
    {
    	return Integer.bitCount(x^y);
    }
}
