
public class TotalSumInBTWithTarget {
	static class  TreeNode{
	    int val = 0;
	    TreeNode left;
	    TreeNode right;
	    public TreeNode(int val) {
	      this.val = val;
	    }
	  }
	  
	  int globalSum = 0;
	  TreeNode target;
	  public int sumTotal(TreeNode root, TreeNode target) {
	    this.target = target;
	    postOrder(root, -1);
	    return globalSum;
	  }
	  
	  public int postOrder(TreeNode root, int len) {
	    if(root == null) return -1;//<-------
	    if(root == target) {
	      preOrder(root, 0);
	      return 1;
	    }
	    int left = postOrder(root.left, len);
	    int right = postOrder(root.right,len);
	    if(left == -1 && right == -1) {
	      return -1;
	    } else {
	      if(left != -1) {
	        globalSum += left + 1;
	        preOrder(root.right, left + 2);
	      } else {
	        globalSum += right + 1;
	        preOrder(root.left, right + 2);
	      }
	      return left == -1 ? right + 1: left + 1;
	    }
	  }

	  public void preOrder(TreeNode root, int len) {
	    if(root == null) return;
	    globalSum += len;
	    if(root.left != null) preOrder(root.left, len + 1);
	    if(root.right != null) preOrder(root.right, len + 1);
	  }
	  
	  public static void main(String[] args) {
	    
	    TreeNode n1 = new TreeNode(1);
	    
	    n1.left = new TreeNode(2);
	    n1.right = new TreeNode(3);
	    
	    n1.left.left = new TreeNode(4);
	    n1.left.right = new TreeNode(5);
	   
	    n1.right.right = new TreeNode(6);

	    System.out.println(new TotalSumInBTWithTarget().sumTotal(n1, n1.right));
	    
	  }
}
