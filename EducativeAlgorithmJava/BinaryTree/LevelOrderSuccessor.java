import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderSuccessor {

	public static TreeNext findSuccessor(TreeNext root, int key) {
	      Deque<TreeNext> que = new LinkedList<>();
				que.offerLast(root);
	      boolean flag = false;
				 while(!que.isEmpty()) {
				    int size = que.size();
				    for(int i = 0; i < size; i++) {
				      TreeNext curr = que.pollFirst();
	            if(flag) return curr;
				      if(curr.left != null) que.offerLast(curr.left);
				      if(curr.right != null) que.offerLast(curr.right);
				      if(curr.val == key) {
	              flag = true;
				      }
				    }
	       }
		    return null;
	  }

	  public static void main(String[] args) {
	    TreeNext root = new TreeNext(12);
	    root.left = new TreeNext(7);
	    root.right = new TreeNext(1);
	    root.left.left = new TreeNext(9);
	    root.right.left = new TreeNext(10);
	    root.right.right = new TreeNext(5);
	    TreeNext result = LevelOrderSuccessor.findSuccessor(root, 12);
	    if (result != null)
	      System.out.println(result.val + " ");
	    result = LevelOrderSuccessor.findSuccessor(root, 9);
	    if (result != null)
	      System.out.println(result.val + " ");
	  }

}
