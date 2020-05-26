import generator.TreeNode;

public class Solution98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Pre Order with Min and Max variables
    //left and right: expect chekcing result from subtrees
    //current: check  min < current.val < max
    //return current result and subtree results
    public boolean isValidBST(TreeNode root) {
        return isValidBSTPreOrder(root, null, null);
    }
    
    private boolean isValidBSTPreOrder(TreeNode root, Integer min, Integer max){
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isValidBSTPreOrder(root.left, min, root.val) && isValidBSTPreOrder(root.right, root.val, max);
    }
}
