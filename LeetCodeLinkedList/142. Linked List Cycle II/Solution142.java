/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 1, 2017 7:40:44 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution142 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(6, 0, 10);
		input.print();
		System.out.println();

		detectCycle(input);
		input.print();
		System.out.println();
	}
	
    public static ListNode detectCycle(ListNode head) 
    {
    	if(head==null || head.next==null) return null;
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next!=null && fast.next.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		if(slow==fast)
    		{
    			ListNode start =head;
    			while(start!=slow)
    			{
    				start=start.next;
    				slow=slow.next;
    			}
    			return slow;
    		}
    	}
    	return null;
    }
}
