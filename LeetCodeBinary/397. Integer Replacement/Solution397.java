/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 23, 2017 3:25:00 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
 */

public class Solution397 {
	public static void main(String[] args) 
	{
		int input =9;
		System.out.println(integerReplacement(input));
	}
    public static  int integerReplacement(int n) 
    {
    	if (n<=1) return 0;
    	int result=0;
    	while(n!=1)
    	{
    		if( (n&1)==0)
    		{
    			n/=2;
    		}
    		else
    		{
    			if (n==3 || ((n>>1)&1)==0)
    			{
    				n--;
    			}
    			else
    			{
    				n++;
    			}
    		}
    		result++;
    	}
        return result;
    }

}
