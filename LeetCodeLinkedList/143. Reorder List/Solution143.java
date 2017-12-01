
/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 30, 2017 12:04:57 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution143 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(2, 1, 2);
		input.print();
		System.out.println();

		reorderList(input);
		input.print();
		System.out.println();
	}
	
	public static void reorderList(ListNode head)
	{
		if(head==null||head.next==null) return;
		ListNode p1 = head;
		ListNode p2 = head;
		while(p2.next!=null && p2.next.next!=null)
		{
			p1=p1.next;
			p2=p2.next.next;
		}
		
		ListNode preMid= p1;
		ListNode postMid= p1.next;
		while(postMid.next!=null)
		{
			ListNode temp = postMid.next;
			postMid.next = temp.next;
			temp.next=preMid.next;
			preMid.next=temp;
		}
		
		p1=head;
		p2=preMid.next;
		
		while(p1!=preMid)
		{
			preMid.next=p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1=p2.next;
			p2=preMid.next;
		}
	}

}
