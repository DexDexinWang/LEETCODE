/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 30, 2017 9:08:28 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution92 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		ListNode output = reverseBetween(input,5,8);
		output.print();
		System.out.println();
	}
	
    public static ListNode reverseBetween(ListNode head, int m, int n) 
    {
    	if(head==null || head.next == null) return head;
    	if(m*n<0) return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next=head;
    	ListNode start = dummy;
    	for(int i = 0 ; i< m-1; i++)
    	{
    		start=start.next;
    	}
    	ListNode first = start.next;
    	ListNode second = first.next;
    	for(int i=0; i<n-m; i++)
    	{
    		first.next=second.next;
    		second.next=start.next;
    		start.next = second;
    		second=first.next;
    	}
    	return dummy.next;
    }

}
