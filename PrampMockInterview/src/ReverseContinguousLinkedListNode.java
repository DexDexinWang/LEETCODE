class Node {
	    int data;
	    Node next;
	    Node(int x) {
	      data = x;
	      next = null;
	    }
	  }
public class ReverseContinguousLinkedListNode {
	 
	
	 public static void main(String[] args) {
		 Node dummy = new Node(-1);
		 Node curr = dummy;
		 for(int temp : new int[]{1, 2, 8, 9, 12, 16} ) {
			 curr.next = new Node(temp);
			 curr = curr.next;
		 }
		 Node res = new ReverseContinguousLinkedListNode().reverse(dummy.next);
		 while(res!= null) {
			 System.out.println(res.data);
			 res = res.next;
		 }
	 }
	
	
	  //For each step: i prefer to find the pre node of even value node. 
	  //
	  public Node reverse(Node list){
		  Node dummy = new Node(-1);
	      dummy.next = list;
	      Node left = dummy;
	      Node right = left;
	      int count = 0;
	      while(right!= null) {
	        if(right.next == null || right.next.data % 2 == 1 ) {
	          if(count >= 2) {
	            Node tempHead = left.next;
	            Node tempEnd = right;
	            
	            right = right.next;
	            left.next = null;
	            tempEnd.next = null;
	            reverseHelper(tempHead);
	            
	            left.next = tempEnd;
	            tempHead.next = right;
	            left = right;
	            count = 0;
	          } else {
	            right = right.next;
	            left = right;
	          }
	        } else {
	          right = right.next;
	          count++;
	        }
	      }
	      return dummy.next;
	  }
	  
	  public Node reverseHelper(Node head) {
	        if(head == null || head.next == null) {
	            return head;
	        }
	        Node newHead = new Node(-1);
	        Node curr = head;
	        
	        while(curr != null) {
	            Node tempCurr = curr;
	            curr = curr.next;
	            Node tempNext = newHead.next;
	            newHead.next = tempCurr;
	            newHead.next.next = tempNext;
	        }
	        return newHead.next;
	  }
}
