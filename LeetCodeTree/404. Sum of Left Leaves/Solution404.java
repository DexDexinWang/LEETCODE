/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 9:33:41 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24. 
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution404 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println("\nOutput:"+sumOfLeftLeaves(input));
	}
	
    public static int sumOfLeftLeaves(TreeNode root) 
    {
    	//recursive solution, this is faster than iterative solution
    	
    	if(root == null) return 0;
    	int result = 0;
    	if(root.left!=null)
    	{
    		if(root.left.left == null && root.left.right==null)
    		{
    			result += root.left.val;
    		}
    		else
    		{
    			result += sumOfLeftLeaves(root.left);
    		}
    	}
    	
    	result += sumOfLeftLeaves(root.right);
    	
    	return result;
    
    	
    	//iterative solution
    	/*
    	int result = 0;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if (root == null) return 0;
    	stack.push(root);
    	while(!stack.isEmpty())
    	{
    		TreeNode node = stack.pop();
    		if(node.left!=null)
    		{
    			if(node.left.left==null && node.left.right==null)
    			{
    				result += node.left.val;
    			}
    			else
    			{
    				stack.push(node.left);
    			}
    		}
    		if(node.right!=null)
    		{
    			stack.push(node.right);
    		}
    	}
    	return result;
    	*/
    }
    
}
