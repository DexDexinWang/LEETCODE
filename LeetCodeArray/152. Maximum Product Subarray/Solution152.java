/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 7:21:58 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.ArrayRandom;

public class Solution152 {
	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(maxProduct(input));
	}
    public static int maxProduct(int[] nums) 
    {
    	if(nums==null || nums.length==0) return 0;
    	int max = nums[0],min = nums[0],result = nums[0];
    	for(int i=1;i<nums.length;i++)
    	{
    		int temp = max;
    		max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
    		min = Math.min(nums[i], Math.min(temp*nums[i], min*nums[i]));
    		if(max>result) result =max;
    	}
    	return result;
    }

}
