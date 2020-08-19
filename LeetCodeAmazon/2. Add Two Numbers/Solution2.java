import generator.ListNode;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 !=null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
            l1=l1 == null ? null : l1.next;
            l2=l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
    
}
