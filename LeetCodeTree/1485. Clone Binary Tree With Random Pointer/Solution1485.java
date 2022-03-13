import java.util.HashMap;
import java.util.Map;

public class Solution1485 {

	public class Node {
		      Node left;
		      Node random;
		      Node right;
		      int val;
		      Node() {}
		      Node(int val) { this.val = val; }
		      Node(int val, Node left, Node right, Node random) {
		         this.val = val;
		         this.left = left;
		         this.right = right;
		          this.random = random;
		      }
		  }
	
	public class NodeCopy {
	      NodeCopy left;
	      NodeCopy random;
	      NodeCopy right;
	      int val;
	      NodeCopy() {}
	      NodeCopy(int val) { this.val = val; }
	      NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	          this.random = random;
	      }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//DFS - Preorder
    //Current: if there is any node in map<>, just link the map to that node. otherwise, create copynode and add pare to map.
    Map<Node, NodeCopy> map;
    public NodeCopy copyProcess(Node root) {
        if (root == null) return null;
        if(!map.containsKey(root)) {
            NodeCopy newRoot = new NodeCopy(root.val);
            map.put(root, newRoot);
            newRoot.left = copyProcess(root.left);
            newRoot.right = copyProcess(root.right);
            newRoot.random = copyProcess(root.random);
            return newRoot;
        } else {
            return map.get(root);
        }
    }
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>();
        return copyProcess(root);
    }
}
