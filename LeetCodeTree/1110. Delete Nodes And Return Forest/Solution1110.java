import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import generator.TreeNode;

public class Solution1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 //Post order
    //left and right: collect forest in sub tree:
    //current: check current value is in to_delete. if yes, then add child nods to result, and delete relations with child.
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new LinkedList<>();
        if (root == null) return res;
        Set<Integer> set = new HashSet<>();
        for(int num: to_delete) {
            set.add(num);
        }
        root = delNodesPostOrder(root, set, res);
        if (root != null) res.add(root);
        return res;
    }
    
    private TreeNode delNodesPostOrder(TreeNode root, Set<Integer> set, List<TreeNode> res) {
        if (root == null) return null;
        root.left = delNodesPostOrder(root.left, set, res);
        root.right = delNodesPostOrder(root.right, set, res);
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        } else {
            return root;
        }
    }
    
}
