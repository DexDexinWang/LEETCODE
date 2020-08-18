/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 6, 2017 6:45:03 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

public class ListNode {
	
	public int val;
	public ListNode next;

	public ListNode()
	{
		val=0;
		next=null;
	}
	
	public ListNode(int x)
	{
		val=x;
		next=null;
	}
	
	public ListNode(int x, ListNode y)
	{
		val=x;
		next=y;
	}
	
	public int length()
	{
		if(next==null)
		{
			return 1;
		}
		else
		{
			return 1+next.length(); 
		}
	}
	
	public void print()
	{
		System.out.print(val);
		if(next!=null){
			System.out.print(" -> ");
			next.print();
		}
	}
}
