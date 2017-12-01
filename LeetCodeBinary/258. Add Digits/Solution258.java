/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 12:19:30 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

import generator.IntegerRandom;

public class Solution258 {

	public static void main(String[] args) 
	{
		int input = IntegerRandom.range();
		System.out.println("input:"+input + "\toutput:"+addDigits(input));
	}
	
    public static int addDigits(int num) {
    	
    	return num==0 ? 0 : ( num % 9 == 0 ? 9 : ( num%9 ));

    }

}
