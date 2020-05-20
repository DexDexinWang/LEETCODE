import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import generator.TreeNode;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 22, 2017 8:59:32 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

public class Solution501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		System.out.print(new Solution501().findMode(root));
	}

	int max = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        findModePreOrder(root, map);
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void findModePreOrder(TreeNode root, Map<Integer,Integer> map) {
        if (root == null) return;
        int count = map.getOrDefault(root.val,0) + 1;
        max = Math.max(max, count);
        map.put(root.val, count);
        findModePreOrder(root.left, map);
        findModePreOrder(root.right, map);
    }
}
