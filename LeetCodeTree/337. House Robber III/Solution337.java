/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 27, 2017 10:21:55 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution337 {

	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println(rob(input));
	}
	
    public static int rob(TreeNode root) 
    {
    	return robDFS(root)[1];
    }
    
    private static int[] robDFS(TreeNode root)
    {
    	int[] result = new int[2];
    	if(root==null) return result;
    	int[] l = robDFS(root.left);
    	int[] r = robDFS(root.right);
    	result[0] = l[1]+r[1];
    	result[1] = Math.max(result[0], l[0]+l[0]+root.val);
    	return result;
    }

}
