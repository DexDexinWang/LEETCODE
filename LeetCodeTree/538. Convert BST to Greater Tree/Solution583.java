/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 19, 2017 11:44:58 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution583 {
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		TreeNode output = convertBST(input);
		System.out.println();
		output.print();
	}
	private static int sum =0;
    public static TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        root.val+=sum;
        sum=root.val;
        convertBST(root.left);
        return root;
    }
}
