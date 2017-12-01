/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 8:25:50 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution643 {
	public static void main(String[] args) {
		int[] input={1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(input,4));
	}
	
    public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for(int i =0; i<k; i++)
        {
            sum+=nums[i];
        }
        long max = sum;
        
        for(int i=k; i<nums.length;i++)
        {
            sum+=nums[i]-nums[i-k];
            max=Math.max(max,sum);
        }
        
        return max/1.0/k;
    }

}
