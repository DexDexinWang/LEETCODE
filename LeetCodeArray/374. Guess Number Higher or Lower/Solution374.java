/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 11:45:06 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.ArrayRandom;

public class Solution374 {
	final static int random = ArrayRandom.range(0, 10000); 
	public static void main(String[] args) {
		int input = 10000;
		System.out.println(random+"\t"+guessNumber(input));
	}
	
    public static int guessNumber(int n) {
	    int i = 1, j = n;
	    while(i < j) {
	        int mid = i + (j - i) / 2;
	        if(guess(mid) == 0) {
	            return mid;
	        } else if(guess(mid) == 1) {
	            i = mid + 1;
	        } else {
	            j = mid;
	        }
	    }
	    return i;
    }
    
    private static int guess(int num)
    {
    	if(num==random)
    	{
    		return 0;
    	}
    	else if(num>random)
    	{
    		return -1;
    	}
    	else
    	{
    		return 1;
    	}
    }
    
    
}
