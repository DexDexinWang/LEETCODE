/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 10:30:13 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Determine whether an integer is a palindrome. Do this without extra space.
 */

import generator.ArrayRandom;

public class Solution9 {
	public static void main(String[] args) {
		int input = ArrayRandom.range();
		System.out.println(input+"\t"+isPalindrome(input));
	}
	
    public static boolean isPalindrome(int x) 
    {
    	if (x==0 || (x>0 && x%10 ==0)) return false;
    	int rev=0;
    	while(x>rev)
    	{
    		rev = rev*10+ x%10;
    		x=x/10;
    	}
    	return (x==rev) || (x ==rev/10);
    }


}
