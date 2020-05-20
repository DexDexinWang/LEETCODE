import generator.TreeNode;

public class Solution783 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    TreeNode pre = null;
    int globalMin = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null) {
            return 0;
        }
        minDifferInorderTraverse(root);
        return globalMin;
    }
    
    private void minDifferInorderTraverse(TreeNode root) {
        if(root == null) return;
        minDifferInorderTraverse(root.left);
        if(pre!= null) {
            globalMin = Math.min(globalMin, Math.abs(root.val - pre.val));
        }
        pre = root;
        minDifferInorderTraverse(root.right);
    }
    
}
