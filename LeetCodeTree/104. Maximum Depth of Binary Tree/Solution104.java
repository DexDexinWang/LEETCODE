/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 10:01:33 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import generator.TreeRandom;
import java.util.Deque;
import java.util.LinkedList;
import generator.TreeNode;

public class Solution104 {
	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGen(2, null);
		input.print();
		System.out.println();
		System.out.println(maxDepth(input));
	}
	
    public static int maxDepth(TreeNode root) 
    {
    	
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+Math.max(left,right);
    	/*
    	if (root == null)
    		return 0;
    	
    	Deque<TreeNode> stack = new LinkedList<TreeNode>();
    	
    	stack.push(root);
    	int count = 0;
    	
    	while (!stack.isEmpty()) 
    	{
    		int size = stack.size();
    		while (size-- > 0) 
    		{
    			TreeNode cur = stack.pop();
    			if (cur.left != null)
    				stack.addLast(cur.left);
    			if (cur.right != null)
    				stack.addLast(cur.right);
    		}
    		count++;
    	}
    	return count;
    	*/
    }
}
