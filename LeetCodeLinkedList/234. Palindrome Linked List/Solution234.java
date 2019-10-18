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

import java.util.Deque;
import java.util.LinkedList;

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution234 {

	public static void main(String[] args) 
	{
		int[] list = new int[] {1,2,2,1};
		ListNode input = LinkedListRandom.genFromArray(list);
		input.print();
		System.out.println("\n"+ isPalindrome1(input));
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
    
    
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        
        Deque<ListNode> stack = new LinkedList<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.offerLast(slow);
        while (fast.next!= null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.offerLast(slow);
        }
        if (fast.next == null) {
            stack.pollLast();
        }
        slow = slow.next;
        while (slow != null) {
            ListNode target = stack.pollLast();
            if (target.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return stack.size() == 0;
    }

}
