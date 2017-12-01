/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 5:46:00 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

import java.util.Random;
public class Solution415 {
	public static void main(String[] args) 
	{
		Random rd = new Random();
		String input1 = Integer.toString(rd.nextInt(100));
		String input2 = Integer.toString(rd.nextInt(100));
		System.out.println("x:"+input1+"\ty:"+input2);
		System.out.println(addStrings(input1, input2));
	}
	
    public static String addStrings(String num1, String num2) 
    {
    	if(num1.length()==0)
    	{
    		return num2;
    	}
    	if(num2.length()==0)
    	{
    		return num1;
    	}
    	StringBuilder result=new StringBuilder();
    	int i = num1.length()-1;
    	int j = num2.length()-1;
    	int carry = 0;
    	while(i>=0 || j>=0 || carry ==1)
    	{
    		int n1= i>=0 ? num1.charAt(i)-48 : 0;
    		int n2= j>=0 ? num2.charAt(j)-48 : 0;
    		int total =n1+n2+carry;
    		result.append((Integer.toString(total%10)));
    		carry = total/10;
    		i--;
    		j--;
    	}
    	result.reverse();
    	return new String(result);
    }
    
    

}
