import java.util.ArrayList;
import java.util.List;

public class Solution802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DFS 
    //How many levels: n levels
    //How many status: n - 1 status. 
    Boolean[] isCycleRes;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int size = graph.length;
        isCycleRes = new Boolean[size];
        boolean[] path = new boolean[size];
        for(int i = 0; i < size; i++) {
            isCycle(graph, i, path);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(!isCycleRes[i]) res.add(i);
        }
        return res;
    }
    
    public boolean isCycle(int[][] graph, int curr, boolean[] path) {
        if(isCycleRes[curr] != null) return isCycleRes[curr];
        if(path[curr]) return true;
        path[curr] = true;
        for(int nei: graph[curr]){
            boolean res = isCycle(graph, nei, path);
            if(res) {
                isCycleRes[curr] = true;
                return res;
            }
        }
        path[curr] = false;
        isCycleRes[curr] = false;
        return false;
    }
}
