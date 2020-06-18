import generator.TreeNode;

public class Solution1145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //A node with value "x" divide a tree as 3 part:left, right, remaining. I have to choose one part which sum(node) > n/2
    //Find Node. count left, right, remaining.
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = target(root, x);
        int left = count(target.left);
        int right = count(target.right);
        int remaining = n - 1 - left - right;
        int max = Math.max(remaining, Math.max(left, right));
        return max > (n/2);
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    
    private TreeNode target(TreeNode root, int x) {
        if (root == null) return null;
        if (root.val == x) return root;
        TreeNode left = target(root.left, x);
        TreeNode right = target(root.right, x);
        return left  == null ? right : left;
    }
}
