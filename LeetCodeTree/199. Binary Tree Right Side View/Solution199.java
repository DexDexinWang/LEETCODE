import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.pollFirst();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if(node.left != null) que.offerLast(node.left);
                if(node.right != null) que.offerLast(node.right);
            }
        }
        return res;
    }
}
