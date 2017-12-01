/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 22, 2017 9:02:18 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//For example, the numbers "69", "88", and "818" are all strobogrammatic.
//


public class Solution246 {
	public static void main(String[] args) 
	{
		String input = "1";
		System.out.println(isStrobogrammatic(input));
	}
	
    public static boolean isStrobogrammatic(String num) 
    {
        for(int i=0, j=num.length()-1; i<=j; i++,j-- )
        {
            if(!"00 11 88 696".contains(num.charAt(i)+""+num.charAt(j)))
            {
                return false;
            }
        }
        return true;
    }

}
