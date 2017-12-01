

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 8:52:29 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
import generator.LinkedListRandom;
import generator.ListNode;

public class Solutuion328 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		ListNode output = oddEvenList(input);
		output.print();
		System.out.println();
	}
	
    public static ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode odd =head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(odd.next!=null && even.next!=null)
        {
        	odd.next=even.next;
        	odd=odd.next;
        	even.next=odd.next;
        	even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

}
