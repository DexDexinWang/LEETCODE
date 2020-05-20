import java.util.LinkedList;
import java.util.Queue;
import generator.TreeNode;

public class CousinsinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		CousinsinBinaryTree test = new CousinsinBinaryTree();
		System.out.print(test.isCousins(root, 2, 3));
		
	}
	
	public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.left == null && root.right == null) {
            return false;
        } 
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(que.size()!= 0) {
            int count = 0;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                boolean meetInt = false;
                if(temp.left != null) {
                    que.offer(temp.left);
                    meetInt = temp.left.val == x || temp.left.val == y;
                } 
                if(temp.right != null) {
                    que.offer(temp.right);
                    meetInt = meetInt || temp.right.val == x || temp.right.val == y;
                } 
                if (meetInt) {
                	count++;
                	if (count == 2) {
                		return true;
                	}
                }
            }
        }
        return false;
    }

}
