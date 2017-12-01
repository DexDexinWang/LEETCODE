/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 12:37:12 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

import generator.ListNode;
import generator.LinkedListRandom;

public class Solution141 {
	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(5);
		input.print();
		System.out.println("\n"+hasCycle(input));
	}
	
    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode l1 = head;
        ListNode l2 = head;
        while(l2.next!=null && l2.next.next!=null)
        {
            l1=l1.next;
            l2=l2.next.next;
            if(l1.val==l2.val)
            {
                return true;
            }
        }
        return false;
    }

}
