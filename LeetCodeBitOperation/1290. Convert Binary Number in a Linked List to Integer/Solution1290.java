
public class Solution1290 {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head!= null) {
            res <<=1;
        	int temp = head.val;
        	res = res | temp;
            head = head.next;
        }
        return res;
    }
}
