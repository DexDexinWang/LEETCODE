import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagTraversal {

	  public static List<List<Integer>> traverse(TreeNext root) {
		    List<List<Integer>> result = new ArrayList<List<Integer>>();
		    Deque<TreeNext> que = new LinkedList<>();
		    que.offerLast(root);
	      boolean isReverse = false;
		    while(!que.isEmpty()) {
		      int size = que.size();
		      List<Integer> temp = new LinkedList<>();
		      for(int i = 0; i < size; i++) {
		        TreeNext curr = que.pollFirst();
		        if(curr.left != null) que.offerLast(curr.left);
		        if(curr.right != null) que.offerLast(curr.right);
	          if(isReverse){
		          temp.add(0, curr.val);
	          } else {
	            temp.add(curr.val);
	          }
		      }
		      result.add(temp);
	        isReverse = !isReverse;
		    }
		    return result;
	  }

	  public static void main(String[] args) {
	    TreeNext root = new TreeNext(12);
	    root.left = new TreeNext(7);
	    root.right = new TreeNext(1);
	    root.left.left = new TreeNext(9);
	    root.right.left = new TreeNext(10);
	    root.right.right = new TreeNext(5);
	    root.right.left.left = new TreeNext(20);
	    root.right.left.right = new TreeNext(17);
	    List<List<Integer>> result = ZigzagTraversal.traverse(root);
	    System.out.println("Zigzag traversal: " + result);
	  }

}
