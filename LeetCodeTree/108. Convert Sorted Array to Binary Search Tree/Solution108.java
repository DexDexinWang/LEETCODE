/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 4:31:28 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 */

import generator.TreeNode;

public class Solution108 {

	public static void main(String[] args) 
	{
		int[] input = {1,2,3,4,5,6,7};
		TreeNode output = sortedArrayToBST(input);
		output.print();
	}
    public static TreeNode sortedArrayToBST(int[] nums) 
    {
        if (nums.length == 0) 
        {
            return null;
        }
        TreeNode root = createTree(nums, 0, nums.length-1);
        return root; 
    }
    
    private static TreeNode createTree(int[] nums, int i, int j)
    {
    	if(i>j)
    	{
    		return null;
    	}
    	int mid = (i+j)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = createTree(nums, i, mid-1);
    	root.right = createTree(nums, mid+1, j);
    	return root;
    }
}
