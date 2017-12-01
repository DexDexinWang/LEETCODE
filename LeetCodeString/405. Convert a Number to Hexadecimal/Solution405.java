/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 15, 2017 10:13:54 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two¡¯s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
 */

import java.util.Random;
public class Solution405 
{
	public static void main(String[] args)
	{
		Random rd = new Random();
		int input = rd.nextInt(20);
		System.out.println(input+"\t"+toHex(input));
	}
	
	//This is a cheating method to avoid the negative maximum value.
    public static String toHex(int num) 
    {
        if (num == 0) return "0";
        char[] map = new char[]
        		{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) 
        {
            sb.insert(0, map[num & 0b1111]);
            num = num >>> 4;
        }
        return sb.toString();
   
    
    
    /*  convert it to long type, it will be different because we have to consider the negative situation.
        long n = num & 0x00000000ffffffffL;
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, map[(int) (n % 16)]);
            n = n / 16;
        }
        return num == 0 ? "0" : sb.toString();
     */
    }
}
