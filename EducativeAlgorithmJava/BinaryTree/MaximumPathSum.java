class MaximumPathSum {

  static int globalMaxSum = 0;

  public static int traverse(TreeNode root) {
    if(root == null) return 0;
    int left = traverse(root.left);
    int right = traverse(root.right);
    globalMaxSum = Math.max(globalMaxSum,(left + right + root.val));
    return Math.max(left, right) + root.val;
  }

  public static int findMaximumPathSum(TreeNode root) {
    if(root == null) return globalMaxSum;
    globalMaxSum = Integer.MIN_VALUE;
    traverse(root);
    return globalMaxSum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
  }
}
