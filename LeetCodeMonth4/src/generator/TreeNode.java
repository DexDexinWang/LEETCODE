/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 9:48:06 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x)
	{
		val=x;
	}
	
	public void print()
	{
		System.out.print("(");
		System.out.print(val);
		if(left!=null)
		{
			this.left.print();
		}
		if(right!=null)
		{
			this.right.print();
		}
		System.out.print(")");
	}
}
