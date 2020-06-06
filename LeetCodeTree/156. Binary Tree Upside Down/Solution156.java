import generator.TreeNode;

public class Solution156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //Post Order
    //upsideDownBinaryTreePostOrder(root, left, right);
    //left: upsideDownBinaryTreePostOrder(root.left, root.right, root);
    //right: upsideDownBinaryTreePostOrder(root.right, null, null);
    TreeNode newRoot = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return root;
        upsideDownBinaryTreePostOrder(root, null, null);
        return newRoot;
    }
    
    public void upsideDownBinaryTreePostOrder(TreeNode root, TreeNode left, TreeNode right) {
        if(root.left == null && root.right == null && newRoot == null){
            newRoot = root;
        }
        if(root.left != null) upsideDownBinaryTreePostOrder(root.left, root.right, root);
        if(root.right != null) upsideDownBinaryTreePostOrder(root.right, null, null);
        root.left = left;
        root.right = right;
    }
}
