
public class Solution426 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	
	class Solution {
	    
	    Node first = null;
	    Node last = null;
	    
	    public Node treeToDoublyList(Node root) {
	        if (root == null) {
	            return root;
	        }
	        inOrderTraverse(root);
	        last.right =first;
	        first.left = last;
	        return first;
	    }
	    
	    private void inOrderTraverse(Node root) {
	        if (root != null) {
	            inOrderTraverse(root.left);
	            if (last != null) {
	                last.right = root;
	                root.left = last;
	            } else {
	                first = root;
	            }
	            last = root;
	            inOrderTraverse(root.right);
	        }  
	    }
	}
}
