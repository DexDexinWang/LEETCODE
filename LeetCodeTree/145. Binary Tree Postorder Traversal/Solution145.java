import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //post order iteration with "previous" TreeNode parameter
    //if prev is null || prev.left == curr || prev.right == curr then add left to stack, or add left to stack; or add val to list
    //if curr.left = prev then add right to stack, add val to list 
    //if curr.right = prev then remove add val to list.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekLast();
            if(prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.offerLast(curr.left);
                } else if (curr.right != null) {
                    stack.offerLast(curr.right);
                } else {
                    stack.pollLast();
                    res.add(curr.val);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.offerLast(curr.right);
                } else {
                    stack.pollLast();
                    res.add(curr.val);
                }
            } else if (curr.right == prev) {
                stack.pollLast();
                res.add(curr.val);
            }
            prev = curr;
        }
        return res;
    }
}
