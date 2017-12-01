/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 11:53:36 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
//
//Example 1:
//Input: 5
//Output: True
//Explanation: 1 * 1 + 2 * 2 = 5
//Example 2:
//Input: 3
//Output: False


public class Solution633 {
	public static void main(String[] args) 
	{
		System.out.println(judgeSquareSum(10));
	}
	
    public static boolean judgeSquareSum(int c) {
        if(c<0) return false;
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left<right)
        {
            int result = left*left+right*right;
            if(result<c)
            {
                left++;
            }
            else if(result>c)
            {
                right--;
            }
            else
            {
                return true;
            }
        }
        return false;
            
    }

}
