
public class Solution117 {

	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        while (head != null) {
            Node prevChild = null;
            Node curr = head;
            head = null;
            while (curr != null) {
                 if (curr.left != null) {
                     if (prevChild != null) {
                         prevChild.next = curr.left;
                     } else {
                         head = curr.left;
                     }
                     prevChild = curr.left; 
                 }
                 if (curr.right != null) {
                     if (prevChild != null) {
                         prevChild.next = curr.right;
                     } else {
                         head = curr.right;
                     }
                     prevChild = curr.right; 
                 }
                curr=curr.next;
            }
        }
        return root;
    }
}
