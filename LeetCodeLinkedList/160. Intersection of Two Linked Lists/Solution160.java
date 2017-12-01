/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 7:26:58 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution160 {

	public static void main(String[] args) 
	{
		ListNode input1 = LinkedListRandom.LLGen(2, 0, 1);
		input1.print();
		System.out.println();
		ListNode input2 = input1;
		input2.print();
		System.out.println();
		ListNode output = getIntersectionNode(input1,input2);
		output.print();
		System.out.println();
	}
	
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        if(headA==null || headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b)
        {
            a = a==null ? headB: a.next;
            b = b==null ? headA: b.next;
        }
        return a;
    }

}
