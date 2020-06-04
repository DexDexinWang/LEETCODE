import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node= que.pollFirst();
                temp.add(node.val);
                if(node.left != null) que.offerLast(node.left);
                if(node.right != null) que.offerLast(node.right);
            }
            res.add(temp);
        }
        return res;
    }

}
