

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 1, 2017 6:43:19 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution86 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(6, 0, 10);
		input.print();
		System.out.println();

		ListNode output = partition(input,5);
		output.print();
		System.out.println();
	}
	
    public static ListNode partition(ListNode head, int x) 
    {
        if(head==null || head.next==null) return head;
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode left = l1;
        ListNode right = l2;
        while(head!=null)
        {
            if(head.val<x)
            {
                left.next=head;
                left=left.next;
            }
            else
            {
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        right.next=null;
        left.next=l2.next;
        return l1.next;
    }

}
