/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 19, 2017 11:14:06 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 
 */

import generator.TreeNode;
import generator.TreeRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {

	public static void main(String[] args) 
	{
		TreeNode input = TreeRandom.treeGen(5, null);
		input.print();
		List<Double> result = averageOfLevels(input);
		System.out.println("\n"+Arrays.toString(result.toArray()));
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<Double>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty())
        {
        	int count = que.size();
        	double sum = 0;
        	for(int i =0; i<count;i++)
        	{
        		TreeNode node = que.poll();
        		sum+=node.val;
        		if(node.left!=null) que.offer(node.left);
        		if(node.right!=null) que.offer(node.right);
        	}
        	result.add(sum/count);
        }
        return result;
    }

}
