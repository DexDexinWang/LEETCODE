import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Best First Search: Topological Ordering
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            List<Integer> res = new ArrayList<>();
            res.add(0); 
            return res;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] countEdge = new int[n];
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(a)) {
                graph.put(a, new HashSet<>());
            }
            graph.get(a).add(b);
            
            if(!graph.containsKey(b)) {
                graph.put(b, new HashSet<>());
            }
            graph.get(b).add(a);
            countEdge[a]++;
            countEdge[b]++;
        }
        
        Deque<Integer> que = new LinkedList();
        List<Integer> res = new ArrayList();
        for(int i = 0; i < n; i++) {
            if(countEdge[i] == 1) {
                que.offerLast(i);
                res.add(i);
            }
        }
        
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> tempRes = new ArrayList();
            for(int i = 0; i < size; i++) {
                int curr = que.pollFirst();
                for(int nei: graph.get(curr)) {
                    countEdge[nei]--;
                    if(countEdge[nei] == 1) {
                        que.offerLast(nei);
                        tempRes.add(nei);
                    }
                }
            }
            if(tempRes.size() != 0) res= tempRes;
        }
        return res;
    }
    
    
    
}
