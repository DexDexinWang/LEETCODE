/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 30, 2017 9:15:05 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();

		ListNode output = swapPairs(input);
		output.print();
		System.out.println();
	}

    public static ListNode swapPairs(ListNode head) 
    {
    	if(head==null || head.next==null) return head;
    	ListNode start = new ListNode(-1);
    	start.next=head;
    	ListNode pre = start;
    	ListNode post = start.next;
    	while(post!=null && post.next!=null)
    	{
    		ListNode temp = post;
    		pre.next=post.next;
    		post=pre.next.next;
    		pre.next.next=temp;
    		pre=temp;
    		temp.next=post;
    	}
    	if (post!=null)
    	{
    		pre.next=post;
    	}
    	return start.next;
    }
}
