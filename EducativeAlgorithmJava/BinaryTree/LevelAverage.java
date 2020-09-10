import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelAverage {
	public static List<Double> findLevelAverages(TreeNext root) {
	    List<Double> result = new ArrayList<>();
		    Deque<TreeNext> que = new LinkedList<>();
		    que.offerLast(root);
		    while(!que.isEmpty()) {
		      int size = que.size();
		      Double sum = 0.0;
		      for(int i = 0; i < size; i++) {
		        TreeNext curr = que.pollFirst();
		        if(curr.left != null) que.offerLast(curr.left);
		        if(curr.right != null) que.offerLast(curr.right);
		        sum+=curr.val;
		      }
		      result.add(sum/size);
		    }
		    return result;
	  }

	  public static void main(String[] args) {
	    TreeNext root = new TreeNext(12);
	    root.left = new TreeNext(7);
	    root.right = new TreeNext(1);
	    root.left.left = new TreeNext(9);
	    root.left.right = new TreeNext(2);
	    root.right.left = new TreeNext(10);
	    root.right.right = new TreeNext(5);
	    List<Double> result = LevelAverage.findLevelAverages(root);
	    System.out.print("Level averages are: " + result);
	  }
}
