import generator.TreeNode;

public class Solution285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    TreeNode previousSatisfiedNode = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (root.val > p.val) {
            previousSatisfiedNode = root;
            root = root.left;
        } else if (root.val < p.val) {
            root = root.right;
        } else {
            return root.right == null ? previousSatisfiedNode: inorderSuccessorHelper(root);
        }
        return inorderSuccessor(root, p);
    }
    
    private TreeNode inorderSuccessorHelper(TreeNode root) {
        if (root.right.left == null) {
            return root.right;
        } else {
            root = root.right;
            while(root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
    
	
}
