import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 8:15:13 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class Solution88 {
	public static void main(String[] args) 
	{
		int[] input1 = {1,3,5,6,0,0,0,0};
		int[] input2 = {2,4,7,8};
		merge(input1,4,input2,4);
		System.out.println(Arrays.toString(input1));
	}
	
    public static void merge(int[] A, int m, int[] B, int n) 
    {
    	int i=m-1;
 		int j=n-1;
 		int k = m+n-1;
 		while(i >=0 && j>=0)
 		{
 			if(A[i] > B[j])
 				A[k--] = A[i--];
 			else
 				A[k--] = B[j--];
 		}
 		while(j>=0)
 			A[k--] = B[j--];
    	
    }

}
