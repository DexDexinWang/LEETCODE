/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 24, 2017 7:31:01 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//There is a fence with n posts, each post can be painted with one of the k colors.
//
//You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//
//Return the total number of ways you can paint the fence.

public class Solution276 {
	public static void main(String[] args) {
		System.out.println(numWays(5,10));
	}
    public static int numWays(int n, int k) 
    {
    	if(n==0) return 0;
    	else if(n==1) return k;
    	
    	int same = k;
    	int diff = (k-1)*k;
    	for(int i=2;i<n;i++)
    	{
    		int temp= diff;
    		diff=(same+diff)*(k-1);
    		same=temp;
    	}
    	return same+diff;
    }
}
