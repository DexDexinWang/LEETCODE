/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 9:51:38 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between 
the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution563 {
	static int result=0;
	public static int findTilt(TreeNode root) 
    {
       sum(root);
       return result;
    }
    public static void main(String[] args) 
	{
		TreeNode input =TreeRandom.treeGenRange(3, null,1,10);
		input.print();
		System.out.println("\n"+findTilt(input));
	}
    
    private static int sum(TreeNode root)
    {
    	 if(root==null) return 0;
         int left = sum(root.left);
         int right =  sum(root.right);
         result+= Math.abs(left-right);
         return root.val + left + right;
    }
    

}
