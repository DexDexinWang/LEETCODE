import generator.TreeNode;

public class Solution998 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void findAndInsertNode(TreeNode root, int val) {
        TreeNode parent = null;
        while(root != null && root.val > val) {
            parent = root;
            root = root.right;
        }
        TreeNode newNode = new TreeNode(val);
        newNode.left = root;
        parent.right = newNode;
    }
    
    //Find a satisfied node is easier
    //According to cases, it will always check right subtree, a new node will be insert as right child and remaing subtree will be insert in left subtree. 
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        findAndInsertNode(root, val);
        return root;
    }
}
