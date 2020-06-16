import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Inorder find prev > current node and swap.
    //Find first prev.val > current.val, record bigger and smaller. Also, it may contain the second prev.val > current.val record smaller. 
    //swap bigger and samller.
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode targetX = null;
        TreeNode targetY = null;
        
        
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            
            root = stack.pollLast();
            if(prev != null && prev.val > root.val) {
                targetY = root;
                if(targetX == null) targetX = prev;
                else break;
            }
            prev = root;
            root = root.right;
        }
        int temp = targetY.val;
        targetY.val  = targetX.val;
        targetX.val = temp;
    }
}
