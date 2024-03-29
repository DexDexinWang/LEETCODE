/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 21, 2017 10:20:02 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given two non-empty binary trees s and t, check whether tree t has exactly 
the same structure and node values with a subtree of s. A subtree of s is a 
tree consists of a node in s and all of this node's descendants. The tree s 
could also be considered as a subtree of itself.
 */

import java.util.ArrayList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution572 {
	public static boolean isSubtree(TreeNode s, TreeNode t) 
    {
    	return transfer(s).contains(transfer(t));
    }
    public static void main(String[] args) {
		TreeNode input1 = TreeRandom.treeGen(5, null);
		TreeNode input2 = input1;
		System.out.println(isSubtree(input1,input2));
		
	}
    private static String transfer(TreeNode root)
    {
    	StringBuilder sb = new StringBuilder();
    	transfer(root,sb);
    	return sb.toString();
    }
    private static void transfer(TreeNode root, StringBuilder sb)
    {
    	if(root==null)
    	{
    		sb.append(",#");
    		return ;
    	}
    	sb.append(","+root.val);
    	transfer(root.left,sb);
    	transfer(root.right,sb);
    }
    
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        List<TreeNode> listRoots = new ArrayList<>();
        findNode(s, t, listRoots);
        for (TreeNode begin : listRoots) {
            return isSameTree(begin, t);
        }
        return false;
    }
    
    private void findNode(TreeNode s, TreeNode t, List<TreeNode> listRoots) {
        if (s!= null && t!= null && s.val == t.val) {
            listRoots.add(s);
        }
        if (s!= null) {
            findNode(s.left,  t, listRoots); 
            findNode(s.right, t, listRoots);
        }
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        } else if (s == null) {
            return false;
        } else if (t!= null) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            return true;
        }
        
    }
}
