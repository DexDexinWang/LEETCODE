/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 9:49:14 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

import java.util.concurrent.ThreadLocalRandom;
import generator.TreeNode;

public class TreeRandom 
{
	private static final int MIN=0;
	private static final int MAX=100000;
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	public static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	/**
	 * To return a random integer with final minimum value and final maximum value
	 */
	public static int range()
	{
		return ThreadLocalRandom.current().nextInt(MIN, MAX);
	}
	
	/**
	 * To return a random binary tree with final minimum value and final maximum value
	 */
	public static TreeNode treeGen(int len, TreeNode root)
	{
		root = new TreeNode(range());
		
		if(len>1)
		{
			root.left = treeGen( len-1 , root);
			root.right = treeGen( len-1 ,  root);
		}
		
		return root;
	}
	
	/**
	 * To return a random binary tree with given minimum value and maximum value
	 */
	public static TreeNode treeGenRange(int len, TreeNode root, int min, int max)
	{
		root = new TreeNode(range(min,max));
		
		if(len>1)
		{
			root.left = treeGenRange( len-1 , root,min,max);
			root.right = treeGenRange( len-1 ,  root,min,max);
		}
		
		return root;
	}
	
	/**
	 * To return a random binary tree with given minimum value and maximum value
	 */
	public static TreeNode treeGenLeftRange(int len, TreeNode root, int min, int max)
	{
		root = new TreeNode(range(min,max));
		
		if(len>1)
		{
			root.left = treeGenLeftRange( len-1 , root,min,max);
		}
		
		return root;
	}
	
}
