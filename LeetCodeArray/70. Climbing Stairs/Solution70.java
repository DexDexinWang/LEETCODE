/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 3:24:41 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

import generator.ArrayRandom;

public class Solution70 
{
	public static void main(String[] args) 
	{
		int input = ArrayRandom.range(0, 10);
		System.out.println(input);
		System.out.println(climbStairs(input));
	}
	
    public static int climbStairs(int n) 
    {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int one=1;
        int two=2;
        int three=0;
        
        for (int i=2; i<n; i++)
        {
        	three =one + two;
        	one = two;
        	two = three;
        }
        return three;
        
        /*Fn = 1/sqr(5) * ((1+sqr(5))/2)^n-(1-sqr(5))/2)^n)*/
    }

}
