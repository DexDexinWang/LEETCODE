import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.add(node.val);
            if (node.right != null) stack.offerLast(node.right);
            if (node.left != null) stack.offerLast(node.left);
        }
        return res;
    }
}
