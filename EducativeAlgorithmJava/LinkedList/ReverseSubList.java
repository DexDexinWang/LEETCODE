
public class ReverseSubList {


		  public static ListNode reverse(ListNode head, int p, int q) {
		    int index = 1;
		    ListNode start = null;
		    ListNode end = null;
		    ListNode curr = head;
		    while(index <= q + 1) {
		      if(index == p - 1) {
		        start = curr;
		      }
		      if(index == q + 1) {
		        end = curr;
		      }
		      curr = curr.next;
		      index++;
		    }
		    
		    ListNode dummy = new ListNode(0);
		    dummy.next = end;
		    curr = start.next;
		    while(curr != end) {
		      ListNode temp = curr.next;
		      curr.next = dummy.next;
		      dummy.next = curr;
		      curr = temp;
		    }
		    start.next = dummy.next;
		    return head;
		  }

		  public static void main(String[] args) {
		    ListNode head = new ListNode(1);
		    head.next = new ListNode(2);
		    head.next.next = new ListNode(3);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(5);

		    ListNode result = ReverseSubList.reverse(head, 2, 4);
		    System.out.print("Nodes of the reversed LinkedList are: ");
		    while (result != null) {
		      System.out.print(result.value + " ");
		      result = result.next;
		    }
		  }
		}

