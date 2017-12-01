import generator.IntegerRandom;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 8:48:11 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution476 {

	public static void main(String[] args) 
	{
		int x = IntegerRandom.range(1,10);
		System.out.println(x);
		System.out.println(~x);
		System.out.println(Integer.toBinaryString(~x));
		System.out.println(Integer.toBinaryString((Integer.highestOneBit(x)<<1) -1));
		System.out.println(Integer.highestOneBit(x));
		System.out.println(Integer.highestOneBit(x)<<1);
		System.out.println((Integer.highestOneBit(x)<<1) -1);
		System.out.println((~x) & ((Integer.highestOneBit(x)<<1) -1));
		System.out.println(Integer.toBinaryString((~x) & ((Integer.highestOneBit(x)<<1) -1)));

	}
	
    public static int findComplement(int num) 
    {
    	int mask = (Integer.highestOneBit(num)<<1) -1;
    	num = ~num;
    	return num & mask;

    }

}
