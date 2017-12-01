/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 8:08:11 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution530 {

	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println("\n"+getMinimumDifference(input));
	}
	
	static int minDiff = Integer.MAX_VALUE;
	static TreeNode prev;
	
    public static int getMinimumDifference(TreeNode root) 
    {
    	inorder(root);
    	return minDiff;
    }
    
    private static void inorder(TreeNode root)
    {
    	if(root==null) 
    	{
    		return ;
    	}
    	inorder(root.left);
    	if(prev!=null)
    	{
    		minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
    	}
    	prev=root;
    	inorder(root.right);
    }
}
