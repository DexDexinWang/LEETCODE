/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 9:34:47 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


public class Solution278 {

	public static void main(String[] args) {
		System.out.println(firstBadVersion(1000));
	}
	
    public static int firstBadVersion(int n) 
    {
        int start = 1;
        int end = n;
        while(start<end)
        {
        	int mid =start+ (end-start)/2;
        	if(!isBadVersion(mid)) start=mid+1;
        	else end=mid;
        }
        return start;
    }

    private static boolean isBadVersion(int n)
    {
    	if(n>500) return false;
    	else return true;
    }
}
