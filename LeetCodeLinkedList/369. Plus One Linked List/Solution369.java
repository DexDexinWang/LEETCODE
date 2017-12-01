/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 17, 2017 4:15:51 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution369 {
	public static void main(String[] args) 
	{
		ListNode input = LinkedListRandom.LLGen(5, 8, 9);
		input.print();
		System.out.println();

		ListNode output = plusOne(input);
		output.print();
		System.out.println();
	}
	
    public static ListNode plusOne(ListNode head) 
    {
    	ListNode dummy =new ListNode(0);
    	dummy.next=head;
    	ListNode i = dummy;
    	ListNode j = dummy;
    	while(j.next!=null)
    	{
    		j=j.next;
    		if(j.val!=9)
    		{
    			i=j;
    		}
    	}
    	
    	if(j.val!=9)
    	{
    		j.val++;
    	}
    	else
    	{
    		i.val++;
    		while(i.next!=null)
    		{
    			i=i.next;
    			i.val=0;
    		}
    	}
    	if(dummy.val==0)
    	{
    		return dummy.next;
    	}
    	else
    	{
    		return dummy;
    	}
    }

}
