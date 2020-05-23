import generator.TreeNode;

public class Solution1325 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || root.left == null && root.right == null && root.val == target) {
            return null;
        } 
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root.left == null && root.right == null && root.val == target ? null: root;
    }

}
