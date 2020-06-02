

public class Solution510 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public Node inorderSuccessor(Node node) {
        if(node.right != null) {
            return inorderSuccessorDown(node);
        }  else {
            return inorderSuccessorUp(node);
        }
    }
    
    public Node inorderSuccessorDown(Node node) {
        if (node.right.left == null) {
            return node.right;
        } else {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    public Node inorderSuccessorUp(Node node) {
        if (node.parent == null) return null;
        if (node.parent.val > node.val) return node.parent;
        return inorderSuccessorUp(node.parent);
    }
}
