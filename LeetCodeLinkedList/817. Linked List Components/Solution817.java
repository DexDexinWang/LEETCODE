import java.util.HashSet;
import java.util.Set;

import generator.ListNode;
public class Solution817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(Integer num : G) {
            set.add(num);
        }
        int res= 0; 
        boolean isPrevValid = false;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                if (!isPrevValid) {
                    res++;
                }
                isPrevValid = true;
            } else {
                isPrevValid = false;
            }
            curr = curr.next;
        }
        return res;
    }
    
}
