/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 11, 2017 5:56:55 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
 * 
 Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

import generator.TreeRandom;
import generator.TreeNode;

public class Solution226 {

	public static TreeNode invertTree(TreeNode root) 
    {
    	if (root == null)
    	{
    		return null;
    	}
    	
    	TreeNode temp = root.left;
    	root.left = invertTree(root.right);
    	root.right = invertTree(temp);
    	
    	return root;
    }
	
    public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(3, null);
		input.print();
		System.out.println();
		TreeNode output = invertTree(input);
		output.print();
	}

}
