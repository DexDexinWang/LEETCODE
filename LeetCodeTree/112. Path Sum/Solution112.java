/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 9:51:56 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution112 {
	//In order
    //left and right : expect checking result in subtrees
    //current: if root is leave, it should check total sum is target or not 
    //return: whether there is path sum is target
    public static boolean hasPathSum(TreeNode root, int sum) 
    {
        if(root==null) return false;
        if(root.left==null && root.right==null && sum-root.val==0) return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(5, null);
		System.out.println(hasPathSum(input,20));
	}
}
