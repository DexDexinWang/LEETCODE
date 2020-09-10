
public class ReverseOddEveryKElements {

	 public static ListNode reverse(ListNode head, int k) {
		    ListNode dummy = new ListNode(0);
		    ListNode start = dummy;
		    start.next = head;
		    int index = 0; 
		    while(start != null) {
		      if(index == 0) {
		        ListNode end = start.next;
		        start.next = reverseFirstK(end, k);
		        start = end;
		      } 
		      while(index < k) {
		        index++;
		        start = start.next;
		      }
		    }
		    return dummy.next;
		  }

		  public static ListNode reverseFirstK(ListNode head, int k) {
		    ListNode dummy = new ListNode(0);
		    while(k > 0) {
		      ListNode temp= head.next;
		      head.next = dummy.next;
		      dummy.next =head;
		      head = temp;
		      k--;
		    }
		    return dummy.next;
		  }

		  public static void main(String[] args) {
		    ListNode head = new ListNode(1);
		    head.next = new ListNode(2);
		    head.next.next = new ListNode(3);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(5);
		    head.next.next.next.next.next = new ListNode(6);
		    head.next.next.next.next.next.next = new ListNode(7);
		    head.next.next.next.next.next.next.next = new ListNode(8);

		    ListNode result = ReverseOddEveryKElements.reverse(head, 2);
		    System.out.print("Nodes of the reversed LinkedList are: ");
		    while (result != null) {
		      System.out.print(result.value + " ");
		      result = result.next;
		    }
		  }
}
