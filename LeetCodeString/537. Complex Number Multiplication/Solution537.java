/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 10, 2017 6:16:42 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 */

public class Solution537 {
	public static void main(String[] args) {
		String input="1+1i";
		System.out.println(complexNumberMultiply(input,input));
	}
	
    public static String complexNumberMultiply(String a, String b) 
    {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        
        return real + "+" + img + "i";
    }
    
    private static int[] getValue(String s) {
        String[] str = s.split("\\+");
        int[] val = new int[2];
        val[0] = Integer.valueOf(str[0]);
        int indexOfI = str[1].indexOf("i");
        val[1] = Integer.valueOf(str[1].substring(0, indexOfI));
        
        return val;
    }
}
