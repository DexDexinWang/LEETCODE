import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.Node;
import generator.TreeNode;

public class Solution431 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n11 = new Node(5);
		Node n12 = new Node(6);
		List<Node> children2 = new LinkedList<>();
		children2.add(n11);
		children2.add(n12);
		Node n1 = new Node(3, children2);
		Node n2 = new Node(2);
		Node n3 = new Node(4);
		List<Node> children1 = new LinkedList<>();
		children1.add(n1);
		children1.add(n2);
		children1.add(n3);
		Node root = new Node(1, children1);
		root = new Node(44, new LinkedList<>());
		TreeNode root1 = new Solution431().encode(root);
		Node root2 = new Solution431().decode(root1);
		System.out.print(root2.val);
	}
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode tree = new TreeNode (root.val);
        Deque<Node> que = new LinkedList<>();
        que.offerLast(root);
        Deque<TreeNode> que1 = new LinkedList<>();
        que1.add(tree);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node node = que.pollFirst();
                TreeNode node1 = que1.pollFirst();
                int j = 0;
                if(node.children != null) {
	                for(Node child : node.children) {
	                    que.offerLast(child);
	                    if (j == 0) {
	                        node1.left = new TreeNode(child.val);
		                    node1 = node1.left;
	                    } else {
	                        node1.right = new TreeNode(child.val);
	                        node1 = node1.right;
	                    }
                        que1.offerLast(node1);
	                    j++;
	                }
                }
            }
        }
        return tree;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> que1 = new LinkedList<>();
        Deque<Node> que2 = new LinkedList<>();
        que1.offerLast(root);
        Node node = new Node(root.val, new LinkedList<>());
        que2.offerLast(node);
        while (!que1.isEmpty()) {
        	TreeNode temp1 = que1.pollFirst();
        	Node temp2 = que2.pollFirst();
        	if(temp1.left!= null) {
        		temp1 = temp1.left;
        		que1.offerLast(temp1);
        		Node newNode = new Node(temp1.val, new LinkedList<>());
        		temp2.children = new LinkedList<>();
        		temp2.children.add(newNode);
        		que2.offerLast(newNode);
        		while(temp1.right!= null) {
        			temp1 = temp1.right;
        			que1.offerLast(temp1);
        			newNode = new Node(temp1.val,new LinkedList<>());
        			temp2.children.add(newNode);
            		que2.offerLast(newNode);
        		}
        	}
        }
        return node;
    }
}
