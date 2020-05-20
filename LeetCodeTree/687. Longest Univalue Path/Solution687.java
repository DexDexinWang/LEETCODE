import generator.TreeNode;

public class Solution687 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		System.out.print(new Solution687().longestUnivaluePath(root));
	}

	//Left and Right: expect returning max path with the same value from subtrees
    //Current1: if left child has the same value as current root, the returned max path will + 1, otherwise 0; Same as right child.
    //Current2: update global max with comparing existing global max and updated left sum + updated right sum;
    //return: max (right sum, left sum)
    int globalMax = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestUnivaluePathInOrder(root);
        return globalMax;
    }
    
    
    private int longestUnivaluePathInOrder(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        } 
        int leftSum = root.left == null ? 0 : longestUnivaluePathInOrder(root.left);
        int rightSum = root.right == null ? 0 : longestUnivaluePathInOrder(root.right);
        leftSum = (root.left != null && root.left.val == root.val) ? leftSum + 1 : 0 ;
        rightSum = (root.right != null && root.right.val == root.val) ? rightSum + 1 : 0 ;
        int crossSum = leftSum + rightSum;
        globalMax = Math.max(globalMax,crossSum);
        return Math.max(leftSum, rightSum);
    }
}
