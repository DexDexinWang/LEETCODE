import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 22, 2017 8:58:49 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
//
//Example 1:
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Note:
//The given array size will in the range [2, 10000].
//The given array's numbers won't have any order.


public class Solution645 {
	public static void main(String[] args) 
	{
		int[] input = {1,2,2,4};
		System.out.println(Arrays.toString(findErrorNums(input)));
	}

    public static int[] findErrorNums(int[] nums) {
        int result[]= new int[2];
        for(int i: nums)
        {
            if(nums[Math.abs(i)-1]<0) result[0] = Math.abs(i);
            else nums[Math.abs(i)-1]*=-1;
        }
        for(int i =0 ; i<nums.length;i++)
        {
            if(nums[i]>0) result[1]=i+1;
        }
        return result;
    }
}
