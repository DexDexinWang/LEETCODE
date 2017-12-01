/**
3 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 11:55:30 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Reverse a singly linked list.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution206 {

	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(4);
		input.print();
		System.out.println();
		ListNode output = reverseList(input);
		output.print();
	}
	
    public static ListNode reverseList(ListNode head) 
    {
    	//recursion
//    	if(head==null || head.next==null)
//    	{
//    		return head;
//    	}
//    	ListNode nextNode = head.next;
//    	ListNode newHead = reverseList(nextNode);
//    	nextNode.next=head;
//    	head.next=null;
//    	return newHead;
//    	
    	//iteration
    	if(head==null || head.next==null)
    	{
    		return head;
    	}
    	ListNode newHead =null;
    	while(head!=null)
    	{
    		ListNode next= head.next;
    		head.next = newHead;
    		newHead = head;
    		head=next;
    	}
    	return newHead;
    }

}
