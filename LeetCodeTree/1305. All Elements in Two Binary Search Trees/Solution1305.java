import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution1305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        while(root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (root1 != null) {
                s1.offerLast(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                s2.offerLast(root2);
                root2 = root2.left;
            }
            
            if (s2.isEmpty() || !s1.isEmpty() && s1.peekLast().val <= s2.peekLast().val) {
                root1 = s1.pollLast();
                res.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = s2.pollLast();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
