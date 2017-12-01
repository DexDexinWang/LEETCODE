/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 7:11:46 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution234 {

	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(5, 0, 1);
		input.print();
		System.out.println("\n"+ isPalindrome(input));
	}
	
    public static boolean isPalindrome(ListNode head) 
    {    
    	if(head==null) return true;
    	ListNode fast = head;
    	ListNode pre = head;
    	ListNode post = head.next;
    	ListNode reverseHead = head;

    	while(fast.next!=null && fast.next.next!=null)
    	{
    		fast=fast.next.next;
    		pre = reverseHead;
    		reverseHead = post;
    		post=post.next;
    		reverseHead.next = pre;
    	}
    	if(fast.next==null)
    	{
    		reverseHead= reverseHead.next;
    	}
    	while(post!=null)
    	{
    		if(reverseHead.val!=post.val)
    		{
    			return false;
    		}
    		reverseHead=reverseHead.next;
    		post=post.next;
    	}
    	return true;
    }

}
