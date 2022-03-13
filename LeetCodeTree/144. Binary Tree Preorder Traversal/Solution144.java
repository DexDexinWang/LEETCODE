import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Java Doc https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> listResult = new LinkedList<>();
        if(root == null) return listResult;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.removeFirst();
            listResult.add(temp.val);
            if(temp.right != null) stack.addFirst(temp.right);
            if(temp.left != null) stack.addFirst(temp.left);
        }
        return listResult;
    }
}
