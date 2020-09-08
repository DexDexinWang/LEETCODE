
public class RearrangeList {

	  public static void reorder(ListNode head) {
		    if (head == null || head.next == null) {
		      return;
		    }
		    ListNode slow = head;
		    ListNode fast = head;
		    while(fast.next != null && fast.next.next != null) {
		      slow = slow.next;
		      fast = fast.next.next;
		    }
		    
		    // 2 4 6 8 10 12
		    ListNode newHead = reverse(slow.next);
		    slow.next = null;
		    ListNode res = new ListNode(-1);
		    ListNode cur = res;
		    while(head!= null && newHead!= null)  {
		      cur.next = head;
		      cur = cur.next;
		      head = head.next;
		      cur.next = newHead;
		      cur = cur.next;
		      newHead = newHead.next;
		    }
		  }

		  public static ListNode reverse(ListNode head) {
		    ListNode dummy = new ListNode(-1);
		    while(head != null) {
		      ListNode temp = head.next;
		      head.next = dummy.next;
		      dummy.next = head;
		      head = temp;
		    }
		    return dummy.next;
		  }

		  public static void main(String[] args) {
		    ListNode head = new ListNode(2);
		    head.next = new ListNode(4);
		    head.next.next = new ListNode(6);
		    head.next.next.next = new ListNode(8);
		    head.next.next.next.next = new ListNode(10);
		    head.next.next.next.next.next = new ListNode(12);
		    RearrangeList.reorder(head);
		    while (head != null) {
		      System.out.print(head.value + " ");
		      head = head.next;
		    }
		  }

}
