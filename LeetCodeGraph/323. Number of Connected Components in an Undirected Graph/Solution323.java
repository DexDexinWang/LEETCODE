import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution323 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Undirected graph with DFS/BFS solution. 
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph  = new HashMap<>();
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
        }
        
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!seen.contains(i)) {
                res++;
                graphTraverse(i, graph, seen);
            }
        }
        return res;
    }
    
    private void graphTraverse(int curr, Map<Integer, Set<Integer>> graph, Set<Integer> seen){
        if(seen.contains(curr)) return;
        seen.add(curr);
        if(graph.containsKey(curr)){
            for(int next: graph.get(curr)){
                graphTraverse(next, graph, seen); 
            }
        }
    }
}
