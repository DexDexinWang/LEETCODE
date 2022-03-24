
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
import java.util.Map;

public class Solution138 {
	
	public static void main(String[] args) {
		System.out.println();
		RandomListNode node0 = new RandomListNode(7);
		RandomListNode node1 = new RandomListNode(13);
		node0.next = node1;
		
		RandomListNode node2 = new RandomListNode(11);
		node1.next = node2;
		
		RandomListNode node3 = new RandomListNode(10);
		node2.next = node3;	
	
		RandomListNode node4 = new RandomListNode(1);
		node3.next = node4;
		
		node1.random = node0;
		node2.random = node4;
		node3.random = node2;
		node4.random = node0;

		RandomListNode output = copyRandomList1(node0);
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

    		RandomListNode copy = new RandomListNode(iter.val);
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
    
    public static RandomListNode copyRandomList1(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode header = head;
        while(head!= null) {
        	RandomListNode newHead = findNode(map, head);
            newHead.next = findNode(map, head.next);
            newHead.random = findNode(map, head.random);
            head = head.next;
        }
        return map.get(header);
    }
    
    private static RandomListNode findNode(Map<RandomListNode,RandomListNode> map, RandomListNode target) {
        if(target == null) return null;
        if(map.containsKey(target)) {
            return map.get(target);
        } else {
        	RandomListNode newTarget = new RandomListNode(target.val);
            map.put(target, newTarget);
            return newTarget;
        }
    }
    

}
