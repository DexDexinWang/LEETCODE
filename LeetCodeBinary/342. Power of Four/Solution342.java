/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 9:06:42 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */


public class Solution342 {

	public static void main(String[] args) 
	{
		int input = 8;
		System.out.println(input + "\t" + isPowerOfFour(input));
	}
	
    public static boolean isPowerOfFour(int num) 
    {
        if(num <= 0) return false;
        if(num == 1) return true;
        return (((num & (num - 1)) == 0) && ((num & 0x55555555) == num));    
    }

}
