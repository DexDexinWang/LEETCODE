/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 6:53:34 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution257 {
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 20);
		input.print();
		System.out.println();
		List<String> output = binaryTreePaths(input);
		System.out.println(Arrays.toString(output.toArray()));
	}
	
    public static List<String> binaryTreePaths(TreeNode root) 
    {
    	List<String> result = new ArrayList<String>();
    	if(root!=null)  path(root, "",result);
    	return result;
    }
    
    private static void path(TreeNode root, String path, List<String> result)
    {
    	if(root.left==null && root.right==null) result.add(path+root.val);
    	if(root.left!=null) path(root.left, path+root.val+"->", result);
    	if(root.right!=null) path(root.right, path+root.val+"->", result);
    }

}
