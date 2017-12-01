/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 13, 2017 4:04:26 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

import generator.LinkedListRandom;
import generator.ListNode;
import generator.TreeNode;

public class Solution109 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		TreeNode output = insertionSortList(input);
		output.print();
		System.out.println();
	}
	
    public static TreeNode insertionSortList(ListNode head) 
    {
        if(head==null) return null;
        return healper(head,null);
    }
    
    public static TreeNode healper(ListNode head, ListNode tail)
    {
    	if(head==tail) return null;
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast!=tail && fast.next!=tail)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	TreeNode root=new TreeNode(slow.val);
    	root.left = healper(head,slow);
    	root.right = healper(slow.next,tail);
    	return root;
    }
}
