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
    
   //Iteration find a path. If root.val == target, return root value. 
    //If root.value > target, min larger value is root, and go left;
    //If root.value < target, min smaller value is root, and go right;
    //final calculate diff min larger and min smaller. 
    public int closestValue1(TreeNode root, double target) {
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        } else {
            TreeNode minSmaller = null;
            TreeNode minLarger = null;
            while (root != null) {
                if (root.val == target) {
                    minSmaller = root;
                    minLarger = root;
                    return root.val;
                } else if (root.val > target) {
                    minLarger = root;
                    root = root.left;
                } else {
                    minSmaller = root;
                    root = root.right;
                }
            }
            if (minSmaller == minLarger) {
                return minSmaller.val;
            } else if (minSmaller == null) {
                return minLarger.val;
            } else if (minLarger == null) {
                return minSmaller.val;
            } else {
                return (target - minSmaller.val) > (minLarger.val - target) ? minLarger.val : minSmaller.val;
            }
        }
    }
}
