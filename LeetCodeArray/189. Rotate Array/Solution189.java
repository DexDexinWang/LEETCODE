/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 12:34:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II

 */

import java.util.Arrays;

import generator.ArrayRandom;

public class Solution189 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 100);
		System.out.println(Arrays.toString(input));
		rotate(input,2);
		System.out.println(Arrays.toString(input));
	}

	public static void rotate(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
}
