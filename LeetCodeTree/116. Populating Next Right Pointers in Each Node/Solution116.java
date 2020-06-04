import java.util.Deque;
import java.util.LinkedList;

public class Solution116 {

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
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//BFS 
    public Node connect(Node root) {
        if (root == null) return root;
    	Deque<Node> deque = new LinkedList<>();
    	deque.offerLast(root);
    	while(!deque.isEmpty()) {
    		int size = deque.size();
    		for(int i = 0 ; i < size; i++) {
    			Node temp = deque.pollFirst();
                if (i == size - 1) {
                    temp.next = null;
                } else {
                    temp.next = deque.peekFirst();
                }
    			if(temp.left != null) deque.offerLast(temp.left);
    			if(temp.right != null) deque.offerLast(temp.right);
    		}
    	}
    	return root;
    }
    
    //Record Header
    public Node connect1(Node root) {
        if (root == null) return root;
    	Node head = root;
        int size = 1;
        while(head.left != null) {
            Node curr = head;
            for(int i = 0; i < size; i++) {
                if(curr != null) {
                    if(i == 0) head = curr.left;
                    curr.left.next = curr.right;
                    if(curr.next != null) curr.right.next = curr.next.left;
                    curr = curr.next;
                }
            }
            size = size << 1;
        }
        
    	return root;
    }

}
