/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 13, 2017 10:39:27 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

*/

import generator.LinkedListRandom;
import generator.ListNode;
public class Solution237 {

	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(5, 0, 5);
		input.print();
		System.out.println();
		deleteNode(input);
		input.print();
	}

    public static void deleteNode(ListNode node) 
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
