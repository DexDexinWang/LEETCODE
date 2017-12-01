/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 8, 2017 11:43:07 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Solution412 {

	public static void main(String[] args) {
		Random rd=new Random();
		int input =rd.nextInt(10)+1;

		List<String> output=fizzBuzz(input);
		for(String s: output)
		{
			System.out.println(s);
		}
	}
	
	/*Solution without mod*/
    public static List<String> fizzBuzz(int n) 
    {
    	List<String> result =new ArrayList<String>();
        for(int i=1, fizz=3, buzz=5; i<=n ;i++)
        {
        	if (i==fizz && i==buzz)
        	{
        		result.add("FizzBuzz");
        		fizz+=3;
        		buzz+=5;
        	}
        	else if(i==fizz)
        	{
        		result.add("Fizz");
        		fizz+=3;
        	}
        	else if(i==buzz)
        	{
        		result.add("Buzz");
        		buzz+=5;
        	}
        	else
        	{
        		result.add(String.valueOf(i));
        	}
        }
        return result;
    }
    
	/*
	Solution with mod
    public static List<String> fizzBuzz(int n) 
    {
    	List<String> result =new ArrayList<String>();
        for(int i=1; i<=n ;i++)
        {
        	if (i%3==0 && i%5==0)
        	{
        		result.add("FizzBuzz");
        	}
        	else if(i%3==0)
        	{
        		result.add("Fizz");
        	}
        	else if(i%5==0)
        	{
        		result.add("Buzz");
        	}
        	else
        	{
        		result.add(String.valueOf(i));
        	}
        }
        return result;
    }
    */

}
