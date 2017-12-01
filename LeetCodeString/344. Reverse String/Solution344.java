/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 9, 2017 12:45:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.StringRandom;

public class Solution344 {

	public static void main(String[] args) 
	{
		String input = StringRandom.strAlphabetGen(10);
		System.out.println(input);
		String output = reverseString(input);
		System.out.println(output);
	}
	
    public static String reverseString(String s) {
    	/* StringBuilder supplies a simplest way to do with more time cost.
        StringBuilder sb =new StringBuilder(s);
        return sb.reverse().toString();
        */
    	
    	char[] c = s.toCharArray();
    	int i = 0;
    	int j = s.length()-1;
    	while(i<j)
    	{
    		char temp =c[i];
    		c[i] = c[j];
    		c[j] = temp;
    		i++;
    		j--;
    	}
    	return new String(c);
    }

}
