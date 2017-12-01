/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 2:30:48 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer, write a function to determine if it is a power of three.
 */

import java.util.Random;

public class Solution326 {
	public static void main(String[] args) {
		Random rd = new Random();
		int input = rd.nextInt();
		System.out.println(input + "\t" + isPowerOfThree(input));
	}
	
    public static boolean isPowerOfThree(int n) 
    {
        //cheating solution
    	return ( n>0 &&  1162261467%n==0);
    	
    	//recursive solution
    	//    return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));

    	//Radix-3
    	//return Integer.toString(n, 3).matches("10*");

    }

}
