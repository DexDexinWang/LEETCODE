import generator.TreeNode;

public class Solution951 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }else if (root1== null || root2 == null || root1.val != root2.val) {
            return false;
        } else {
            return  (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) ||
                (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
        }
    }

}
