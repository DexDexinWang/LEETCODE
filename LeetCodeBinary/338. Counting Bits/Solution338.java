import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 9:37:29 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non negative integer number num. For every numbers i in the range 0 ¡Ü i ¡Ü num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */

public class Solution338 {
	public static void main(String[] args) 
	{
		int input = 5;
		System.out.println(Arrays.toString(countBits(input)));
	}
	/*An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.*/
    public static int[] countBits(int num) 
    {
    	int[] result = new int[num+1];
    	for(int i=1;i<=num; i++)
    	{
    		result[i] = result[i >> 1] + (i & 1);
    	}
        return result;
    }
    
    /*
    Without bit operations

	public class Solution 
	{
	    public int[] countBits(int num) 
	    {
	        int[] answer = new int[num+1];
	        int offset = 1;
	        for(int i = 1; i < answer.length; i++)
	        {
	            if(offset * 2 == i) offset *= 2;
	            answer[i] = 1 + answer[i - offset];
	        }
	        return answer;
	    }
	} 
     */

}
