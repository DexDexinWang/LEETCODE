import generator.TreeNode;

public class Solution1448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    int count = 0;
    public int goodNodes(TreeNode root) {
        goodNodesPreOrder(root, root.val);
        return count;
    }
    
    private void goodNodesPreOrder(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) count++;
        max = Math.max(max, root.val);
        goodNodesPreOrder(root.left, max);
        goodNodesPreOrder(root.right, max);
        
    }
}
