/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 23, 2017 1:25:50 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
//
//So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
//
//Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.
//
//Example 1:
//Input: 9
//Output: 10
//Hint: n will not exceed 9 x 10^8.
//


public class Solution660 {
	public static void main(String[] args) 
	{
		System.out.println(newInteger(9));
	}
	
    public static int newInteger(int n) {
		int ans = 0;
		int base = 1;
			
		while (n > 0){
			ans += n % 9 * base;
			n /= 9;
			base *= 10;
		}
		return ans;
    }

}
