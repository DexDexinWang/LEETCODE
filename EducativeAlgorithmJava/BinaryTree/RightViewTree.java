import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
	    Deque<TreeNode> que = new LinkedList<>();
	    que.offerLast(root);
	    while(!que.isEmpty()) {
	      int size = que.size();
	      for(int i = 0; i < size; i++) {
	        TreeNode curr = que.pollFirst();
	        if(curr.left != null) que.offerLast(curr.left);
	        if(curr.right != null) que.offerLast(curr.right);
	        if(i == size -1) result.add(curr);
	      }
	    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}

