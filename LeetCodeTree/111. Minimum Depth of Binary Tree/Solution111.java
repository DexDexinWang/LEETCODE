/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 1, 2017 3:37:47 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/*Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along 
the shortest path from the root node down to the nearest leaf node.
*/

import generator.TreeNode;
import generator.TreeRandom;

public class Solution111 {
	public static void main(String[] args) {
		TreeNode input1 = TreeRandom.treeGen(5, null);
		System.out.println(new Solution111().minDepth(input1));
	}
	
	//left, right: expecting min path number from subtrees
    //current: consider special case if one node only has 1 child, it will only consider that path rather then Null.
    //return: get min path number from left subtree and right subtree + 1
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (root.left == null || root.right == null) ? left + right + 1: Math.min(left, right) + 1;
    }

}
