/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 8:40:21 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor is defined between two nodes v and 
w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant 
of itself according to the LCA definition.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution235 {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	while((root.val-p.val)*(root.val-q.val)>0)
    	{
    		root = p.val < root.val ? root.left : root.right;
    	}
    	return root;
    }
	
    public static void main(String[] args) 
	{
		TreeNode input1 = TreeRandom.treeGen(4, null);
		TreeNode input2 = TreeRandom.treeGen(1, null);
		TreeNode input3 = TreeRandom.treeGen(1, null);
		input1.print();
		System.out.println();
		input2.print();
		System.out.println();
		input3.print();
		System.out.println();
		lowestCommonAncestor(input1,input2,input3).print();
		System.out.println();
	}

}
