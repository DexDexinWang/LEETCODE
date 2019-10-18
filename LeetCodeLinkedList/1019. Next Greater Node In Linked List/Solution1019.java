import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.ListNode;

public class Solution1019 {

	public static void main(String[] args) {
		
	}
	
    public int[] nextLargerNodes1(ListNode head) {
        if (head == null) {
        	return new int[] {};
        }
        
        List<ListNode> list =new ArrayList<>();
        for(ListNode cur= head; cur!= null; cur = cur.next) {
            list.add(cur);
        }
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i).val > list.get(stack.peekLast()).val) {
              res[stack.pollLast()] = list.get(i).val;  
            }
            stack.offerLast(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pollLast()] = 0;
        }
        return res;
    }

	
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
        	return new int[] {};
        }
        List<Integer> tempRes = new ArrayList<>();
        while(head!= null) {
            ListNode temp = head.next;
            boolean added = false;
            while (temp!= null) {
               if (temp.val > head.val) {
                   added = true;
                   tempRes.add(temp.val);
                   break;
               } else {
                   temp = temp.next;
               }
            }
            if (!added) {
                tempRes.add(0);
            }
            head = head.next;
        }
        int[] res = new int[tempRes.size()];
        int count = 0;
        for(Integer num : tempRes) {
        	res[count++] = num;
        }
        return res;
        
    }

}
