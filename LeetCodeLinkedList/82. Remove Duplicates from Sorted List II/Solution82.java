

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 30, 2017 11:07:43 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution82 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();

		ListNode output = deleteDuplicates(input);
		output.print();
		System.out.println();
	}
	
    public static ListNode deleteDuplicates(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	ListNode newHead = new ListNode(-1);
    	ListNode current = newHead;
    	ListNode next = head;
    	current.next = head;
    	while(next!=null)
    	{
    		while(next.next!=null && next.val== next.next.val)
    		{
    			next=next.next;
    		}
    		if(current.next==next)
    		{
    			current=current.next;
    		}
    		else
    		{
    			current.next=next.next;
    		}
    		next=next.next;
    	}
    	
    	return newHead.next;
    }
}
