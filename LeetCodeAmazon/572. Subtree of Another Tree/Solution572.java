import generator.TreeNode;

public class Solution572 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return ((s.val == t.val) ? isSameTree(s,t): false) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        } 
        if(s== null || t == null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right); 
    }
}
