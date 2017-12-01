/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 22, 2017 9:44:23 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//Note:
//Given target value is a floating point.
//You are guaranteed to have only one unique value in the BST that is closest to the target.

import generator.TreeNode;
import generator.TreeRandom;

public class Solution270 {
	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGenLeftRange(3, null, 0, 10);
		input.print();
		System.out.println("\n"+closestValue(input,5));
	}
    public static int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root!=null)
        {
            if(Math.abs(target-root.val)<Math.abs(target-result))
            {
                result = root.val;
            }
            root=root.val > target ? root.left: root.right;
        }
        return result;
    }
}
