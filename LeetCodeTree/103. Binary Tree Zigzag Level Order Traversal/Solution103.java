import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean isReverse = false;
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tempRes = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node= deque.pollFirst();
                if (!isReverse) { 
                    tempRes.add(0,node.val) ;
                } else {
                    tempRes.add(node.val);
                }
                if (node.right != null) deque.offerLast(node.right);
                if (node.left!=null) deque.offerLast(node.left);
            }
            isReverse = !isReverse;
            res.add(tempRes);
        }
        return res;
    }
}
