import generator.TreeNode;

public class Solution124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Post Order
    //left and right: expect max path sum from subtrees
    //return: max(leftsum, rightsum) + curr.val;
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumPostOrder(root);
        return globalMax;
    }
    
    private int maxPathSumPostOrder(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(maxPathSumPostOrder(root.left), 0);
        int rightSum = Math.max(maxPathSumPostOrder(root.right), 0);
        globalMax = Math.max(globalMax, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }

}
