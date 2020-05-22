import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution230 {
	public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
