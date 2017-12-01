/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 6, 2017 8:58:02 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListRandom 
{
	private static final int MIN=0;
	private static final int MAX=100000;
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	private static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	/**
	 * To generate a random array with given length
	 */
	public static ListNode LLGen(int len)
	{
		if(len<1)
		{
			return null;
		}
		ListNode head=new ListNode(range(MIN,MAX));
		ListNode temp=head;
		while (head.length()<len)
		{
			temp.next=new ListNode(range(MIN,MAX));
			temp=temp.next;
		}
		return head;
	}
	/**
	 * To generate a random array with given length and given range
	 */
	public static ListNode LLGen(int len, int min, int max)
	{
		if(len<1)
		{
			return null;
		}
		ListNode head=new ListNode(range(min,max));
		ListNode temp=head;
		while (head.length()<len)
		{
			temp.next=new ListNode(range(min,max));
			temp=temp.next;
		}
		return head;
	}
}
