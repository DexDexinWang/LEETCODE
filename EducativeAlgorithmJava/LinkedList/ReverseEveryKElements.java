
public class ReverseEveryKElements {

	  public static ListNode reverse(ListNode head, int k) {
		    ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode start = dummy;
		    ListNode end = head;
		    int index = 1;
		    while(end!= null) {
		      if(index < k) {
		        end = end.next;
		        index++;
		      } else {
		        ListNode remining = end.next;
		        end.next = null;
		        ListNode nextEnd = start.next;
		        start.next = reverseK(start.next);
		        start = nextEnd;
		        nextEnd.next = remining;
		        end = remining;
		        index = 1;
		      }
		    }
		    start.next = reverseK(start.next);
		    return dummy.next;
		  }

		  public static ListNode reverseK(ListNode start) {
		    ListNode dummy = new ListNode(0);
		    while(start != null) {
		      ListNode next = start.next;
		      start.next = dummy.next;
		      dummy.next =start;
		      start = next;
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

		    ListNode result = ReverseEveryKElements.reverse(head, 3);
		    System.out.print("Nodes of the reversed LinkedList are: ");
		    while (result != null) {
		      System.out.print(result.value + " ");
		      result = result.next;
		    }
		  }
}
