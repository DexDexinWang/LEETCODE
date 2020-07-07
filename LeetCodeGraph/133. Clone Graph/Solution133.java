import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Solution133 {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS
    //Choose a node to be expended: given node.
    //for each expended node, make a copy node and add copy neighbors which will be added to copy node.
    //Termination, all nodes visited
    //For this BFS, I will use Queue to maintain it.
    
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> visited = new HashMap<>();
        Deque<Node> que = new LinkedList<>();
        que.offerLast(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        
        while(!que.isEmpty()) {
            Node target = que.pollFirst();    
            for(Node nei: target.neighbors) {
                if(!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val, new ArrayList<>()));
                    que.offerLast(nei);
                }
                visited.get(target).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
    
    //DFS 
    //How many level? Could be N levels 
    //How many status in each level? 1. node is null return. 2. node is exist in hashmap return the copy node. 3. otherwise, create new node, copy neibors in recursion to copy neighbors which will be added to new node.
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph1(Node node) {
        if (node == null) return node;
        if (visited.containsKey(node)) return visited.get(node);
        Node copyNode = new Node(node.val, new ArrayList<>());
        visited.put(node, copyNode);
        for(Node nei: node.neighbors) {
            copyNode.neighbors.add(cloneGraph(nei));
        }
        return copyNode;
    }
}
