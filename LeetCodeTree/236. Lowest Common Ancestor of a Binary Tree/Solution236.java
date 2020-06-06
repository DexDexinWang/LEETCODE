import generator.TreeNode;

public class Solution236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes != null && rightRes != null) return root;
        if (leftRes != null || rightRes != null) return (root == p || root == q) ? root : (leftRes == null? rightRes: leftRes);  
        return root == p || root == q ? root: null;
    }
}
