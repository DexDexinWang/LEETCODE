/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 26, 2017 11:38:37 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
/*
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
 */

import generator.TreeRandom;
import generator.TreeNode;

public class Solution623 {
	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGen(3, null);
		TreeNode output = addOneRow(input,2,2);
		output.print();
	}
	
    public static TreeNode addOneRow(TreeNode root, int v, int d) 
    {
    	if(d==1 || d==0)
    	{
    		TreeNode newRoot = new TreeNode(v);
    		newRoot.left = d==1 ? root:null;
    		newRoot.right = d==0 ? root:null;
    		return newRoot;
    	}
    	if(root!=null && d>=2)
    	{
    		root.left = addOneRow(root.left,v,d>2?d-1:1);
    		root.right = addOneRow(root.right,v,d>2?d-1:0);
    	}
    	return root;
    }

    
    /*
        public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null || d==0) return null;
        if(d==1)
        {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left=root;
            return newRoot;
        }
        return add(root,v,d,2);
    }
    public TreeNode add(TreeNode root, int v, int d, int m)
    {
        if(root==null) return null;
        
        if(m==d)
        {
            TreeNode left = new TreeNode(v);
            left.left= root.left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.left=left;
            root.right=right;
            return root;
        }
        else
        {
            m++;
            root.left=add(root.left,v,d, m);
            root.right=add(root.right,v,d,m);
        }
        return root;
    }
     */

}
