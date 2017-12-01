/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 8:20:46 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Sort a linked list in O(n log n) time using constant space complexity.

 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution148 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		ListNode output = sortList(input);
		output.print();
		System.out.println();
	}

    public static ListNode sortList(ListNode head) 
    {
        //bottom case
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode fast=head;
        ListNode slow=head;
        ListNode pre = head;
        while(fast!=null && fast.next!=null)
        {
        	pre=slow;
        	slow=slow.next;
        	fast = fast.next.next;
        }
        //cut the cause;
        pre.next=null;
        
        ListNode p1= sortList(head);
        ListNode p2= sortList(slow);
        
        return merge(p1,p2);
    }
    
    private static ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val)
        {
            l1.next = merge(l1.next,l2);
            return l1;
        }else
        {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
