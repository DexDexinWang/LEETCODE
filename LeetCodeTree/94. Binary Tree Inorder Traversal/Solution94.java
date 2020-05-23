import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root!= null) {
            while(root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
