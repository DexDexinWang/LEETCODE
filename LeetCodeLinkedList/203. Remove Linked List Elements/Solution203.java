/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 29, 2017 9:38:32 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import generator.LinkedListRandom;
import generator.ListNode;
public class Solution203 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 1);
		input.print();
		System.out.println();
		ListNode output = removeElements(input, 0);
		output.print();
		System.out.println();
	}
	
    public static ListNode removeElements(ListNode head, int val) {
        if( head==null) return null;
        head.next=removeElements(head.next,val);
        return head.val==val ? head.next : head;
    }

}
