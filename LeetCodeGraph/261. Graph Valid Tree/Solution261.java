import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //undirected graph: BFS or DFS
    //Tree: 1. all nodes are connected.  2. no cycle
    //BFS DFS check , only allow one neighbor from parent. otherwise, return false; 
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
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
        return !FindCycle(0, seen, graph, -1) && seen.size() == n;
    }
    
    private boolean FindCycle(int k, Set<Integer> seen, Map<Integer, Set<Integer>> graph, int parent) {
        if (seen.contains(k)) return true;
        if (!graph.containsKey(k)) return false;
        seen.add(k);
        boolean res = false;
        for(int next: graph.get(k)) {
            if(next == parent) continue;
            res = FindCycle(next, seen, graph, k);
            if(res) break;
        }
        return res;
    }
}
