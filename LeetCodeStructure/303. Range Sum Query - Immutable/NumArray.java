/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 11:36:08 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


public class NumArray {
    int[] sums;
    public NumArray(int[] nums) 
    {
        for(int i =1;i<nums.length;i++)
        {
            nums[i]=nums[i]+nums[i-1];
        }
        this.sums=nums;
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return sums[j];
        return sums[j]-sums[i-1];
    }
}
