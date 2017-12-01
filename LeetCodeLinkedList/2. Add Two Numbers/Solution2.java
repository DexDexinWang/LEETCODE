/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 2, 2017 9:53:50 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution2 {

	public static void main(String[] args) 
	{
		int i=3;
		ListNode l1=LinkedListRandom.LLGen(i,1,9);
		ListNode l2=LinkedListRandom.LLGen(i,1,9);
		l1.print();
		System.out.println();
		l2.print();
		System.out.println();
		
		ListNode result = addTwoNumbers(l1, l2);
		result.print();
		System.out.println();
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode result = new ListNode(-1);
        ListNode current = result;
        int carry = 0;
        while(l1!=null || l2!=null)
        {
            int sum = (l1==null? 0: l1.val)+(l2==null? 0:l2.val)+carry;
            ListNode tail = new ListNode(sum%10);
            current.next = tail;
            current=current.next;
            carry=sum/10;
            l1 = l1==null? null: l1.next;
            l2 = l2==null? null: l2.next;
        }
        if(carry==1)
        {
            current.next = new ListNode(1);
        }
        return result.next;
	}
}
