/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 4:53:25 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two binary trees, write a function to check if they are equal or not.
 */

import generator.TreeRandom;
import generator.TreeNode;

public class Solution100 {
	public static void main(String[] args) 
	{
		TreeNode input1 = TreeRandom.treeGen(3, null);
		input1.print();
		System.out.println();
		TreeNode input2 = TreeRandom.treeGen(3, null);
		input2.print();
		System.out.println();
		System.out.println(isSameTree(input1,input2));
	}
	
    public static boolean isSameTree(TreeNode p, TreeNode q) 
    {
    	if(p==null && q== null) return true;
    	if(p==null || q== null) return false;
    	if(p.val==q.val)
    	{
    		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    	}
    	return false;
    }

}
