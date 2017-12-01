/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 21, 2017 8:59:30 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution110 {
	public static void main(String[] args) 
	{
		TreeNode root = TreeRandom.treeGen(3, null);
		System.out.println(isBalanced(root));
	}
    public static boolean isBalanced(TreeNode root) 
    {
    	return height(root)!=-1;  
    }
    private static int height(TreeNode node)
    {
    	if(node==null) return 0;
    	int lH = height(node.left);
    	if(lH!=-1)
    	{
    		int rH = height(node.right);
    		if(rH!=-1) return Math.abs(lH-rH)>1?-1:Math.max(lH,rH)+1;
    	}
    	return -1;
    }

}
