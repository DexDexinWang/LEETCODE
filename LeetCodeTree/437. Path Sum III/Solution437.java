/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 6:30:30 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */

import generator.TreeNode;
import generator.TreeRandom;
import java.util.HashMap;

public class Solution437 {

	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGenLeftRange(3, null, 1, 10);
		input.print();
		System.out.println();
		
		pathSum(input, TreeRandom.range(0, 15));
	}

	public static int pathSum(TreeNode root, int sum) 
    {
		if(root == null) return 0 ;
    	HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
    	counter.put(0, 1);
    	return findPathSum(root,0,sum,counter);
    }

	private static int findPathSum(TreeNode curr, int sum, int target,HashMap<Integer,Integer> map )
	{
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0); 
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                                               + findPathSum(curr.right, sum, target, map);
       // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
	}
}
