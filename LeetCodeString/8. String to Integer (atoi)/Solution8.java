/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 27, 2017 3:08:31 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 */

import generator.StringRandom;

public class Solution8 {
	public static void main(String[] args) {
		String input = StringRandom.strNumGen(5);
		System.out.println(input+"\t"+myAtoi(input));
	}
    public static int myAtoi(String str) {
        
        if(str==null||str.length()==0) return 0;
        str=str.trim();
        char[] list=str.toCharArray();
        int sign=1,start=0, end = list.length;
        if(list[0]=='+')
        {
            sign=1;
            start++;
        } else if( list[0]=='-')
        {
            sign=-1;
            start++;
        }
        
        long result =0;
        while(start<end)
        {

            if(!Character.isDigit(list[start]))
            {
                return (int) result * sign;
            }
            result = result*10 +(list[start] -'0');
            
	    	if (sign == 1 && result > Integer.MAX_VALUE)
	    		return Integer.MAX_VALUE;
		    if (sign == -1 && (-1) * result < Integer.MIN_VALUE)
	    		return Integer.MIN_VALUE;
	    	start++;
        }
        
        return (int) result * sign;
    }

}
