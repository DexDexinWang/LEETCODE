/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 1, 2017 8:15:27 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class Solution67 {
	public static void main(String[] args) 
	{
		System.out.println("reuslt:"+addBinary("1","11"));
	}
    public static String addBinary(String a, String b) 
    {
    	char[] l1=a.toCharArray();
    	char[] l2=b.toCharArray();
    	int len1 = l1.length-1;
    	int len2 = l2.length-1;
    	StringBuilder result = new StringBuilder();
    	int carry=0;
    	while(len1>=0 || len2>=0)
    	{
    		int sum = carry;
    		if(len1>=0) sum+= l1[len1]-'0';
    		if(len2>=0) sum+= l2[len2]-'0';
    		len1--;
    		len2--;
    		result.append(sum%2);
    		carry = sum / 2;
    	}
    	if(carry==1)
    	{
    		result.append(carry);
    	}
    	return result.reverse().toString();
    }

}
