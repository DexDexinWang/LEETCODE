import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution1361 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Directed Acyclic Graph 
    //BFS 
    //Coose a node to be expanded. 0
    //Generate new nodes for each expanded node. that is not seen before
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] pointTos = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (leftChild[i] != -1) pointTos[leftChild[i]] = true;;
            if (rightChild[i] != -1) pointTos[rightChild[i]] = true;;
        }
        
        int root = -1;
        for(int i =0; i < n; i++) {
            if(!pointTos[i]) {
                if(root != -1) return false;
                root = i;
            }
        }
        
        if (root == -1) return false;
        
        Set<Integer> seen = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int curr = queue.pollFirst();
            if(seen.contains(curr)) return false;
            seen.add(curr);
            if(leftChild[curr] != -1) queue.offerLast(leftChild[curr]);
            if(rightChild[curr] != -1) queue.offerLast(rightChild[curr]);
        }
        return seen.size() == n;
    }
}
