import generator.TreeNode;

public class Solution450 {
	public TreeNode deleteNode(TreeNode root, int target) {
        TreeNode prev = null;
		TreeNode cur = root;
		
		while(cur != null) {
			if (cur.val == target) {
				break;
			} else if (cur.val > target) {
				prev = cur;
				cur= cur.left;
			} else {
				prev = cur;
				cur = cur.right;
			}
		}
		if (cur == null) return root;
		
		if(cur.left != null && cur.right != null) {
			
			if (cur.right.left == null) {
				cur.right.left = cur.left;
				if (prev == null) {
					return cur.right;
				} else {
					if (prev.val > cur.val) {
						prev.left = cur.right;
					} else {
						prev.right = cur.right;
					}
					
				}
			} else {
				TreeNode next = deleteSmallest(cur.right);
				next.left = cur.left;
				next.right = cur.right;
				if(prev == null) {
					return next;
				} else {
					if (prev.val > cur.val) {
						prev.left = next;
					} else {
						prev.right = next;
					}
				}
			}
			return root;
		} else if (cur.left == null) {
			if (prev == null) {
				return cur.right;
			} else {
				if (prev.val > cur.val) {
					prev.left = cur.right;
				} else {
					prev.right = cur.right;
				}
			}
		} else if (cur.right == null) {
			if (prev == null) {
				return cur.left;
			} else {
				if (prev.val > cur.val) {
					prev.left = cur.left;
				} else {
					prev.right = cur.left;
				}
			}
		} 
		
		return root;
	}
    
    private TreeNode deleteSmallest(TreeNode root) {
		TreeNode leftChild = root.left;
		while(leftChild.left != null) {
			root = root.left;
			leftChild = root.left;
		}
		root.left = leftChild.right;
		leftChild.right = null;
		return leftChild;
	}
}
