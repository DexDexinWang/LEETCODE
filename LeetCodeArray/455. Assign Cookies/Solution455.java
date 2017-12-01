import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 12, 2017 6:25:57 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*
Assume you are an awesome parent and want to give your children some cookies. 
But, you should give each child at most one cookie. Each child i has a greed factor gi, 
which is the minimum size of a cookie that the child will be content with; 
and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, 
and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 */



public class Solution455 
{

	public static void main(String[] args) 
	{
		int[] input1 = {1,2,3};
		int[] input2 = {1,1};
		System.out.println("x:" + Arrays.toString(input1)+"\ty:"+Arrays.toString(input2));
		System.out.println("result:" + findContentChildren(input1,input2));
	}
	
    public static int findContentChildren(int[] g, int[] s) 
    {
    	Arrays.sort(g);
    	Arrays.sort(s);
    	int counter = 0;
        for(int j=0; counter < g.length && j < s.length; j++)
        {
        	if(g[counter]<=s[j])
        	{
        		counter++;
        	}
        }
        return counter;
    }

}
