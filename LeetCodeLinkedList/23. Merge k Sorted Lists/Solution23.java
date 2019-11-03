import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import generator.ListNode;
public class Solution23 {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		a1.next = new ListNode(4);
		a1.next.next = new ListNode(5);
		ListNode b1 = new ListNode(1);
		b1.next = new ListNode(3);
		b1.next.next = new ListNode(4);
		ListNode c1 = new ListNode(2);
		c1.next = new ListNode(6);
		ListNode[] lists = new ListNode[]{a1,b1,c1};
		
		Solution23 test = new Solution23();
		test.mergeKLists(lists);
		
	}
	
	 public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) {
	            return null;
	        } else if (lists.length == 1) {
	        	return lists[0];
	        }
	        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a,b)->a.val-b.val);
	        for(ListNode node: lists) {
                if (node != null) {
	        	    pq.offer(node);
                }
	        }
	        ListNode dummy = new ListNode(-1);
	        ListNode curr = dummy;
	        while(pq.size() > 0) {
	        	curr.next = pq.poll();
	        	curr = curr.next;
                if (curr.next != null) {
	        	    pq.offer(curr.next);
                }
	        }
	        return dummy.next;
	    }

}
