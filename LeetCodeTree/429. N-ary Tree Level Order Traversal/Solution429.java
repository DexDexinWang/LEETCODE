import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.Node;

public class Solution429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> que = new LinkedList<>();
        que.offerLast(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                Node temp = que.pollFirst();
                level.add(temp.val);
                for(Node child: temp.children) {
                    que.offerLast(child);
                }
            }
            res.add(level);
        }
        return res;
    }
   
}
