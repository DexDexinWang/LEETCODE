/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 11:27:11 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.*/

import generator.IntegerRandom;

public class Solution371 
{
	public static void main(String[] args) 
	{
		int a = IntegerRandom.range(1, 500);
		int b = IntegerRandom.range(1, 500);
		System.out.println("a:"+a+"\tb:"+b+"\tResult:"+getSum(a,b));
	}
	
    public static int getSum(int a, int b) 
    {
    	if (a == 0) return b;
    	if (b == 0) return a;

    	while (b != 0) {
    		int carry = a & b;
    		a = a ^ b;
    		b = carry << 1;
    	}
    	return a;
    }

}
