/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 7:19:09 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
 */

import generator.ArrayRandom;

public class Solution507 {
	public static void main(String[] args) {
		int input = ArrayRandom.range(0, 10000);
		System.out.println(input+"\t"+checkPerfectNumber(input));
	}
	
    public static boolean checkPerfectNumber(int num) 
    {
    	if(num==1) return true;
    	int sum=1;
    	int i =2;
    	while( i <= Math.sqrt(num))
    	{
    		if(num%i==0)
    		{
    			sum+=(i+num/i); 
    		}
    		i++;
    	}
    	return sum == num;
    }

}
