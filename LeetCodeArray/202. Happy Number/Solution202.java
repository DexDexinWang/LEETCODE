/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 1:52:11 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

import java.util.Random;

public class Solution202 {
	public static void main(String[] args) 
	{
		Random rd = new Random();
		int input = rd.nextInt(100);
		System.out.println(input + "\t" + isHappy(input));
	}
	
    public static boolean isHappy(int n) 
    {
        int x = n;
        int y = n;
        while(x>1)
        {
            x = calculator(x) ;
            if(x==1) return true;
            y = calculator(calculator(y));
            if(y==1) return true;

            if(x==y) return false;
        }
        return true;
    }
    
    private static int calculator(int n)
    {
    	int x = n;
    	int s = 0;
    	while(x>0)
    	{
    		s+=Math.pow(x%10,2);
    		x=x/10;
    	}
    	return s;
    }

}
