/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 24, 2017 2:37:40 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ¡Ü x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ¡Ü x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class Solution357 {

	public static void main(String[] args) 
	{
		System.out.println(countNumbersWithUniqueDigits(10));
	}

    public static int countNumbersWithUniqueDigits(int n) 
    {
    	if ( n==0) return 1;
    	int result=10;
    	int currentUniques=9;
    	int availableNums=9;
    	while(n-->1 && availableNums>0)
    	{
    		currentUniques= currentUniques* availableNums;
    		result+=currentUniques;
    		availableNums--;
    	}
    	return result;
    }
}
