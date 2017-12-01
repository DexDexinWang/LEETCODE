/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 30, 2017 3:50:39 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution19 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		ListNode output = removeNthFromEnd(input,5);
		output.print();
		System.out.println();
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) 
    {
    	ListNode start = new ListNode(-1);
    	ListNode fast = start;
    	ListNode slow = start;
    	start.next=head;
    	for(int i = 0 ; i<=n; i++)
    	{
    		fast=fast.next;
    	}
    	while(fast.next!=null)
    	{
    		fast=fast.next;
    		slow=slow.next;
    	}
    	slow.next=slow.next.next;
    	return start.next;
    }

}
