import java.util.*;

class TreeNext {
	  int val;
	  TreeNext left;
	  TreeNext right;
	  TreeNext next;

	  TreeNext(int x) {
	    val = x;
	    left = right = next = null;
	  }

	  // level order traversal using 'next' pointer
	  void printLevelOrder() {
	    TreeNext nextLevelRoot = this;
	    while (nextLevelRoot != null) {
	      TreeNext current = nextLevelRoot;
	      nextLevelRoot = null;
	      while (current != null) {
	        System.out.print(current.val + " ");
	        if (nextLevelRoot == null) {
	          if (current.left != null)
	            nextLevelRoot = current.left;
	          else if (current.right != null)
	            nextLevelRoot = current.right;
	        }
	        current = current.next;
	      }
	      System.out.println();
	    }
	  }
	};

class ConnectLevelOrderSiblings {
	
	
  public static void connect(TreeNext root) {
    Deque<TreeNext> que = new LinkedList<>();
    que.offerLast(root);
    while(!que.isEmpty()) {
      int size = que.size();
      TreeNext head = null;
      for(int i = 0; i < size; i++) {
        TreeNext curr = que.pollFirst();
        if(curr.left != null) que.offerLast(curr.left);
        if(curr.right != null) que.offerLast(curr.right);
        if(head == null) {
          head = curr;
        } else {
          head.next = curr;
          head = head.next;
        }
      }
    }
  }

  public static void main(String[] args) {
    TreeNext root = new TreeNext(12);
    root.left = new TreeNext(7);
    root.right = new TreeNext(1);
    root.left.left = new TreeNext(9);
    root.right.left = new TreeNext(10);
    root.right.right = new TreeNext(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}
