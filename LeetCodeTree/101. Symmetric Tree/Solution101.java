/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 9:58:30 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution101 {

	public static void main(String[] args) {
		TreeNode input1 = TreeRandom.treeGen(5, null);
		System.out.println(isSymmetric(input1));
	}
	
    public static boolean isSymmetric(TreeNode root) 
    {
    	if(root==null) return true;
    	return isMirror(root.left,root.right);
    }
    
    private static boolean isMirror(TreeNode left, TreeNode right)
    {
        if(left==null && right == null) return true;
        if(left==null || right == null) return false;
        return (left.val==right.val) && isMirror(left.right,right.left) && isMirror(left.left,right.right);
    }

}
