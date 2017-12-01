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
		System.out.println(minDepth(input1));
	}
	
    private static int minDepth(TreeNode root) 
    {
        if (root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left==0 || right ==0) ? left+right+1 : Math.min(left, right)+1;
    }

}
