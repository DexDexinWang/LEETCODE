import java.util.HashMap;
import java.util.Map;

import generator.ListNode;

public class Solution1171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode cur = dummy;            
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }
        
        cur = dummy;
        sum = 0;
        while(cur!= null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
