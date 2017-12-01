/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 27, 2017 10:34:54 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import generator.TreeNode;

public class Solution95 {
	public static void main(String[] args) 
	{
		System.out.println(Arrays.toString(generateTrees(2).toArray()));
	}

	public static List<TreeNode> generateTrees(int n) 
	{
		List<TreeNode>[] result = new List[n+1];
		result[0] = new ArrayList<TreeNode>();
		if(n==0) return result[0];
		
		result[0].add(null);
		for(int len = 1 ; len <=n ; len++)
		{
			result[len] = new ArrayList<TreeNode>();
			for(int j = 0 ; j<len; j++)
			{
				for(TreeNode nodeL : result[j])
				{
					for(TreeNode nodeR : result[len-j-1])
					{
						TreeNode node = new TreeNode(j+1);
						node.left = nodeL;
						node.right = clone(nodeR,j+1);
						result[len].add(node);
					}
				}
			}
		}
		return result[n];
    }
	
	private static TreeNode clone(TreeNode n , int offset)
	{
		if(n==null) return null;
		TreeNode node= new TreeNode(n.val+offset);
		node.left=clone(n.left,offset);
		node.right=clone(n.right,offset);
		return node;
	}
}
