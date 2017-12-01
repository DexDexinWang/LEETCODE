

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 6:19:22 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 */

import java.util.LinkedList;
import java.util.List;
import generator.TreeNode;
import generator.TreeRandom;

public class Solution107 {
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println();
	}
	
    public static List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    	addLevel(result, 0, root);
    	return result;
    }
    
    private static void addLevel( LinkedList<List<Integer>> result, int level,TreeNode root)
    {
    	if(root==null) return ;
    	if(result.size()-1<level) result.addFirst(new LinkedList<Integer>());
    	result.get(result.size()-1-level).add(root.val);
    	addLevel(result, level+1, root.left);
    	addLevel(result, level+1, root.right);
    }
    
}
