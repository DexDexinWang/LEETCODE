/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 4:13:38 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */

import generator.TreeRandom;

import generator.TreeNode;

public class Solution543 
{
	static int max =0;
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println(diameterOfBinaryTree(input));
	}
	
    public static int diameterOfBinaryTree(TreeNode root) 
    {
    	maxDepth(root);
    	return max;
    }
    
    private static int maxDepth(TreeNode root)
    {
    	if(root == null)
    	{
    		return 0;
    	}
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	
    	max = Math.max(max, left+right);
    	
    	return Math.max(left,right)+1;
    }
    
}
