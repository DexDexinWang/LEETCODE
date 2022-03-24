import generator.TreeNode;

public class Solution865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS Post Order
    //1. DFS get the deepest value.
    //2. DFS check each node. 
    //left and right: expect the deepest nodes.
    //current: if left res is not null and right res is not null return current. Otherwise return not null value. 
    //Return: return the deepest node.
    private int deepest = Integer.MIN_VALUE;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        dfsUpdateDeepest(root, 0);
        return dfsGetDeepestNode(root, 0);
    }
    
    private TreeNode dfsGetDeepestNode(TreeNode root, int depth) {
        if(root == null || depth == deepest) return root;
        TreeNode left = dfsGetDeepestNode(root.left, depth + 1);
        TreeNode right = dfsGetDeepestNode(root.right, depth + 1);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
    
    private void dfsUpdateDeepest(TreeNode root, int depth) {
        if(root == null) return;
        if(depth > deepest) deepest = depth;
        dfsUpdateDeepest(root.left, depth + 1);
        dfsUpdateDeepest(root.right, depth + 1);
    }
}
