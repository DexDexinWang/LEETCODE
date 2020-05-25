import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution515 {
    //BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while(!que.isEmpty()) {
            int size = que.size();
            int max = que.peekFirst().val;
            for(int i = 0; i < size; i++) {
                TreeNode temp = que.pollFirst();
                if(temp.val > max) {
                    max = temp.val;
                }
                if(temp.left != null) que.offerLast(temp.left);
                if(temp.right != null) que.offerLast(temp.right);
            }
            res.add(max);
        }
        return res;
    }
}
