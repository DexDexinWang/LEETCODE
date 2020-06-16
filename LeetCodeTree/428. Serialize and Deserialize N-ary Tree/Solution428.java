import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution428 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
	}

	

	class Codec {
	    // Encodes a tree to a single string.
	    public String serialize(Node root) {
	        StringBuilder sb = new StringBuilder();
	        serializePreOrder(root, sb);
	        return sb.toString();
	    }
	    
	    private void serializePreOrder(Node root, StringBuilder sb) {
	        if(root == null) {
	            return;
	        }
	        sb.append(root.val+"");
	        for(Node child: root.children) {
	            sb.append("(");
	            serializePreOrder(child, sb);
	            sb.append(")");
	        }
	    }
		
	    // Decodes your encoded data to tree.
	    int index = 0;
	    char[] chars;
	    public Node deserialize(String data) {
	        if(data == null || data.length() == 0) return null;
	        this.chars = data.toCharArray();
	        Deque<Node> stack = new LinkedList<>();
	        Node root = new Node(getCharValue());
	        stack.offerLast(root);
	        while(index < data.length()) {
	            if(this.chars[index] == '(') {
	                index++;
	                continue;
	            } else if (chars[index] == ')') {
	                index++;
	                stack.pollLast();
	            } else {
	                Node child = new Node(getCharValue());
	                Node parent = stack.peekLast();
	                if(parent.children == null) {
	                    parent.children = new LinkedList<>();
	                }
	                parent.children.add(child);
	            }
	        }
	        return root;
	    }
	    
	    public int getCharValue() {
	        StringBuilder sb = new StringBuilder();
	        while(index < chars.length && chars[index] != '(' && chars[index] != ')') {
	            sb.append(chars[index++]);
	        }
	        return Integer.parseInt(sb.toString());
	    }
	}
	
}

