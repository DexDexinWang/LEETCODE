import java.util.*;

class ConnectAllSiblings {
  public static void connect(TreeNext root) {
    Deque<TreeNext> que = new LinkedList<>();
    que.offerLast(root);
    TreeNext dummy = new TreeNext(0);
    TreeNext point = dummy;
    while(!que.isEmpty()) {
      int size = que.size();
      for(int i = 0; i < size; i++) {
        TreeNext curr = que.pollFirst();
        point.next = curr;
        point = point.next;
        if(curr.left != null) que.offerLast(curr.left);
        if(curr.right != null) que.offerLast(curr.right);
      }
    }
    dummy.next = null;
  }

  public static void main(String[] args) {
    TreeNext root = new TreeNext(12);
    root.left = new TreeNext(7);
    root.right = new TreeNext(1);
    root.left.left = new TreeNext(9);
    root.right.left = new TreeNext(10);
    root.right.right = new TreeNext(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNext current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}