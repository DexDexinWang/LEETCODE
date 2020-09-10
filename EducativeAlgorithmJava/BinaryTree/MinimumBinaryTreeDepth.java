import java.util.Deque;
import java.util.LinkedList;

public class MinimumBinaryTreeDepth {
	 public static int findDepth(TreeNext root) {
	        Deque<TreeNext> que = new LinkedList<>();
			    que.offerLast(root);
	        int level = 1;
			    while(!que.isEmpty()) {
			      int size = que.size();
			      for(int i = 0; i < size; i++) {
			        TreeNext curr = que.pollFirst();
			        if(curr.left != null) que.offerLast(curr.left);
			        if(curr.right != null) que.offerLast(curr.right);
			        if(curr.left == null && curr.right == null) return level;
			      }
			      level++;
			    }
			
	    return -1;
	  }

	  public static void main(String[] args) {
	    TreeNext root = new TreeNext(12);
	    root.left = new TreeNext(7);
	    root.right = new TreeNext(1);
	    root.right.left = new TreeNext(10);
	    root.right.right = new TreeNext(5);
	    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	    root.left.left = new TreeNext(9);
	    root.right.left.left = new TreeNext(11);
	    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	  }
}
