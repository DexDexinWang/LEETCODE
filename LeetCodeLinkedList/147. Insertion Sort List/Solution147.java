/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 4, 2017 11:42:54 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*Sort a linked list using insertion sort.*/

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution147 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 10);
		input.print();
		System.out.println();

		ListNode output = insertionSortList(input);
		output.print();
		System.out.println();
	}
    public static ListNode insertionSortList(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        
        ListNode pre = head;
        ListNode current = head.next;
        while(current!=null)
        {
        	if(current.val >= pre.val)
        	{
        		current=current.next;
        		pre=pre.next;
        	}
        	else
        	{
        		pre.next=current.next;
        		if(current.val<=head.val)
        		{
        			current.next=head;
        			head = current;
        		}
        		else
        		{
        			ListNode search=head;
        			while(search.next!=null && search.next.val<current.val)
        			{
        				search=search.next;
        			}
        			ListNode temp = search.next;
        			search.next= current;
        			current.next=temp;
        		}
        		current=pre.next;
        	}
        }
        return head;
    }

}
