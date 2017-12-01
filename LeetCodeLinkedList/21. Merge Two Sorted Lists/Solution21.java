/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 7:15:12 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution21 {
	public static void main(String[] args) 
	{
		ListNode input1= LinkedListRandom.LLGen(10,1,3);
		input1.print();
		System.out.println();
		ListNode input2 = LinkedListRandom.LLGen(10,1,3);
		input2.print();
		System.out.println();
		ListNode output =mergeTwoLists(input1,input2);
		output.print();
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
    	if(l1==null) return l2;
    	if(l2==null) return l1;
    	if(l1.val<l2.val)
    	{
    		l1.next = mergeTwoLists(l1.next,l2);
    		return l1;
    	}
    	else
    	{
    		l2.next = mergeTwoLists(l1,l2.next);
    		return l2;
    	}
    }

}
