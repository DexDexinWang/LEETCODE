import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1462 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution1462().checkIfPrerequisite(2, new int[][] {{1,0}}, new int[][] {{1,0},{0,1}});
	}
    //DFS search for each query.
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        Boolean[][] relations = new Boolean[n][n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge: prerequisites){
            int start  = edge[1];
            int end = edge[0];
            graph.putIfAbsent(start, new LinkedList<>());
            graph.get(start).add(end);
            relations[start][end] = true;
        }
        
        for(int i = 0; i < queries.length; i++ ) {
            int[] query = queries[i];
            int start = query[1];
            int end = query[0];
            boolean[] visited = new boolean[n];
            res.add(dfs(graph, start, end, visited, relations));
        }
        return res;
    }
    
    private boolean dfs(Map<Integer,List<Integer>> graph, int start, int end, boolean[] visited, Boolean[][] relations){
        if(start == end) return true;
        if(!graph.containsKey(start)) return false;
        if(relations[start][end] != null) return relations[start][end];
        if(visited[start]) return false;
        visited[start] = true;
        for(int target: graph.get(start)) {
            boolean ret = dfs(graph, target, end, visited, relations);
            relations[target][end] = ret;
            if(ret) return true;
        }
        return false;
    }
    //DP
    //Base rule: DP[0][0] = false there is no class that one class is its self required class.
    //Induction rule: DP[i][j] = DP[i][j] || DP[i][k] && DP[k][j] 
    
}
