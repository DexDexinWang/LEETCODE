import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution173 {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class BSTIterator {
	    TreeNode root = null;
	    Deque<TreeNode> stack = new LinkedList<>();
	    public BSTIterator(TreeNode root) {
	        this.root = root;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return root != null || !stack.isEmpty();
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        if (root != null || !stack.isEmpty()) {
	            int res = 0;
	            while (root != null) {
	                stack.offerLast(root);
	                root = root.left;
	            }
	            if(!stack.isEmpty()) {
	                root = stack.pollLast();
	                res = root.val;
	                root = root.right;
	            }
	            return res;
	        } else {
	            return -1;
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Your BSTIterator object will be instantiated and called as such:
	 * BSTIterator obj = new BSTIterator(root);
	 * int param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */
}
