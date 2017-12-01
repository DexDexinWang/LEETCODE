/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 9:42:16 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*

 */

import generator.LinkedListRandom;
import generator.ListNode;
import java.util.Stack;

public class Solution445 {
	public static void main(String[] args) {
		ListNode input1 = LinkedListRandom.LLGen(5, 0, 9);
		input1.print();
		System.out.println();
		ListNode input2 = LinkedListRandom.LLGen(4, 0, 9);
		input2.print();
		System.out.println();
		
		ListNode output = addTwoNumbers(input1,input2);
		output.print();
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
    	Stack<Integer> set1= new Stack<Integer>();
    	Stack<Integer> set2= new Stack<Integer>();
    	while(l1!=null)
    	{
    		set1.push(l1.val);
    		l1=l1.next;
    	}
    	
    	while(l2!=null)
    	{
    		set2.push(l2.val);
    		l2=l2.next;
    	}
    	int sum=0;
    	ListNode list = new ListNode(0);
    	while(!set1.isEmpty() || !set2.isEmpty())
    	{
    		if(!set1.isEmpty()) sum+=set1.pop();
    		if(!set2.isEmpty()) sum+=set2.pop();
    		list.val=sum%10;
    		ListNode head =new ListNode(sum/10);
    		head.next = list;
    		list = head;
    		sum/=10;
    	}
    	return list.val==0? list.next: list;
    }

}
