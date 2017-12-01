

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 7:47:53 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution61 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode input = LinkedListRandom.LLGen(3, 0, 9);
		input.print();
		System.out.println();
		ListNode output=rotateRight(input,3);
		output.print();
	}
	
    public static ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next ==null || k<=0) return head;
        ListNode current = head;
        int len=1;
        while(current.next!=null)
        {
        	current=current.next;
        	len++;
        }
        current.next=head;
        
        for(int i =0; i<(len-k%len);i++)
        {
        	current=current.next;
        }
        ListNode newHead=current.next;
        current.next=null;
        return newHead;
    }

}
