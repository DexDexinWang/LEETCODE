
/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 13, 2017 4:30:25 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
A linked list is given such that each node contains an additional
 random pointer which could point to any node in the list or null.
Return a deep copy of the list.
 */

import generator.RandomListNode;
import java.util.HashMap;

public class Solution138 {
	
	public static void main(String[] args) {
		System.out.println();
		RandomListNode output = copyRandomList(null);
		System.out.println(output);
	}
	
    public static RandomListNode copyRandomList(RandomListNode head) 
    {
    	/*
    	if (head == null) return head;
    	HashMap<RandomListNode,RandomListNode> map =new HashMap<RandomListNode,RandomListNode>();
    	
    	RandomListNode current = head;
    	while(current!=null)
    	{
    		map.put(current, new RandomListNode(current.label));
    		current=current.next;
    	}
    	
    	current =head;
    	while(current!=null)
    	{
    		map.get(current).next=map.get(current.next);
    		map.get(current).random = map.get(current.random);
    		current = current.next;
    	}
    	return map.get(head);
    	*/
    	
    	RandomListNode iter = head, next;

    	// First round: make copy of each node,
    	// and link them together side-by-side in a single list.
    	while (iter != null) {
    		next = iter.next;

    		RandomListNode copy = new RandomListNode(iter.label);
    		iter.next = copy;
    		copy.next = next;

    		iter = next;
    	}

    	// Second round: assign random pointers for the copy nodes.
    	iter = head;
    	while (iter != null) {
    		if (iter.random != null) {
    			iter.next.random = iter.random.next;
    		}
    		iter = iter.next.next;
    	}

    	// Third round: restore the original list, and extract the copy list.
    	iter = head;
    	RandomListNode pseudoHead = new RandomListNode(0);
    	RandomListNode copy, copyIter = pseudoHead;

    	while (iter != null) {
    		next = iter.next.next;

    		// extract the copy
    		copy = iter.next;
    		copyIter.next = copy;
    		copyIter = copy;

    		// restore the original list
    		iter.next = next;

    		iter = next;
    	}

    	return pseudoHead.next;
    }

}
