import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution919 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		Solution919 test = new Solution919(root);
		test.insert(7);
		test.insert(8);
		test.get_root();
	}
	
    //Consider the input root is complete or not.
    //Consider insert freqeuency. if more then use space to save time.
    Deque<TreeNode> que;   
    TreeNode root;
    public Solution919(TreeNode root) {
        this.root = root;
        if(root != null) {
            que = new LinkedList<>();
            que.offerLast(root);
            while(!que.isEmpty()) {
                TreeNode node = que.peekFirst();
                if(node.left!=null) que.offerLast(node.left);
                else break;
                if(node.right!=null) que.offerLast(node.right);
                else break;
                que.pollFirst();
            }
        }
        
    }
    
    public int insert(int v) {
        TreeNode insert = new TreeNode(v);
        TreeNode root = que.peekFirst();
        if(root.left == null) {
            root.left = insert;    
        } else {
            root.right = insert; 
            que.pollFirst();
        }
        que.offerLast(insert);
        return root.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
