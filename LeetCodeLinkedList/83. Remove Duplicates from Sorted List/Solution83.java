/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 17, 2017 2:48:12 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution83 {
	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(10,1,3);
		input.print();
		System.out.println();
		ListNode output =deleteDuplicates(input);
		output.print();
	}

	public static ListNode deleteDuplicates(ListNode head) 
	{
		if(head == null || head.next == null)return head;
		head.next = deleteDuplicates(head.next);
		return head.val==head.next.val ? head.next : head;
	}
}
