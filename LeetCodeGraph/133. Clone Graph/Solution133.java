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
    //First choose a node to be expended. (Given)
    //expend a node and generate new nodes which will be added to the queue.
    //Termination rule: Que is empty. 
    //The node can be expended only once. Map<Node,Node> visited
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        Deque<Node> que = new LinkedList<>();
        que.offerLast(node);
        while(!que.isEmpty()) {
            Node target = que.pollFirst();
            for(Node nei: target.neighbors) {
                if(!visited.containsKey(nei)){
                    Node newNode = new Node(nei.val, new ArrayList<>());
                    visited.put(nei, newNode);
                    que.offerLast(nei);
                }
                visited.get(target).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
    
    
  //DFS
    //What does it store on each level? Create a Node, and connect previous neighbor.
    //How many different status we will try to put on this level? neighbors
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph1(Node node) {
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        
        Node copyNode = new Node(node.val, new ArrayList<>());
        visited.put(node, copyNode);
        for(Node nei: node.neighbors) {
            copyNode.neighbors.add(cloneGraph(nei));
        }
        return copyNode;
    }
}
