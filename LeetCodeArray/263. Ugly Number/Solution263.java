/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 6:57:52 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */

import generator.ArrayRandom;

public class Solution263 {
	public static void main(String[] args) 
	{
		int input = ArrayRandom.range(0, 10);
		System.out.println(input+"\t"+isUgly(input));
	}
	
    public static boolean isUgly(int num) 
    {
    	//>> is arithmetic shift right, >>> is logical shift right. 
    	//They are both right-shift, but >>> is unsigned

        if(num==0) return false;
        if(num==1) return true;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }

}
