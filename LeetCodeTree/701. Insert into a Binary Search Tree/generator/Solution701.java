package generator;

public class Solution701 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
		TreeNode prev = null;
		while(cur != null) {
			prev = cur;
			if(cur.val > val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		TreeNode newNode = new TreeNode(val);
		if (prev == null) {
			return newNode;
		} else {
			if (prev.val > val) {
				prev.left = newNode;
			} else {
				prev.right = newNode;
			}
		} 
		return root;
    }
}
