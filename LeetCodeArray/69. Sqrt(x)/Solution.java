/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 9:17:38 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.ArrayRandom;

public class Solution {
	public static void main(String[] args) 
	{
		int input = ArrayRandom.range();
		System.out.println(input+"\t"+mySqrt(input));
	}
	
    public static int mySqrt(int x) 
    {
    	long m=x;
    	while(m*m>x)
    	{
    		m=(m+x/m)/2;
    	}
    	return (int) m;
    }
	

}
