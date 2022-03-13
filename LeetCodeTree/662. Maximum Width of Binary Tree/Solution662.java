import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution662 {

	class CalNode{
        int depth, pos;
        TreeNode node;
        CalNode(TreeNode n, int d, int p) {
            this.node = n;
            this.depth = d;
            this.pos = p;
        }
    }
	
    public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		new Solution662().widthOfBinaryTree1(root);
	}
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<CalNode> queue = new LinkedList<>();
        queue.offerLast(new CalNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while(!queue.isEmpty()) {
            CalNode node = queue.pollFirst();
            if(node.node != null) {
                queue.offerLast(new CalNode(node.node.left, node.depth + 1, node.pos * 2));
                queue.offerLast(new CalNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
                if(curDepth != node.depth) {
                    curDepth = node.depth;
                    left = node.pos;
                }
                ans = Math.max(ans, node.pos - left + 1);
            }
            
        }
        return ans;
    }
	
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        int maxWidth = 1;
        while(!que.isEmpty()) {
            int size = que.size();
            int start = -1;
            int numCount = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.pollFirst();
                if(node != null) {
                    if(start == -1) {
                        start = i;
                    } else {
                        maxWidth = Math.max(maxWidth, i - start + 1);
                    }
                }
                que.offerLast(node == null ? null: node.left);
                que.offerLast(node == null ? null: node.right);
                numCount += (node != null && (node.left != null || node.right != null)) ? 1:0;
            }
            if(numCount == 0) {
                que.clear();
            }
        }
        return maxWidth;
    }

}
