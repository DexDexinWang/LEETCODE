import generator.TreeNode;

public class Solution814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Post Order
    //left and right: expect subtrees
    //current, update left node and right node by recursion. check whether both nodes rare null and val == 0.
    //return: if both nodes are null and val is 0 then return null, otherwise return root.
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
