/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 23, 2017 6:59:19 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution513 {
	public static int findBottomLeftValue(TreeNode root) 
    {
    	return findBottomLeftValue(root, 1, new int[]{0,0});
    }

    public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println(findBottomLeftValue(input));
	}
    
    private static int findBottomLeftValue(TreeNode root, int depth, int[] res)
    {
    	if(res[1]<depth) 
    	{
    		res[0]=root.val;
    		res[1]=depth;
    	}
    	if(root.left!=null) findBottomLeftValue(root.left,depth+1,res);
    	if(root.right!=null) findBottomLeftValue(root.right,depth+1,res);
    	return res[0];
    }
}
