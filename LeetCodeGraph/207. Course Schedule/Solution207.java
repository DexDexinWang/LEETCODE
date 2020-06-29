import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Assume that is Directed Graph problem, Solve it with DFS to check wether there is a cycle
    //What does it store on each level? save course relationship with N levels
    //How many different states should we try to put on this level? 
    //1. node is in path, return isCycle. 
    //2. node is not path and is an end point, return not cycle
    //3. node is not path and node has next, check nexts and return res;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int[] relation: prerequisites) {
            int start = relation[1];
            int end = relation[0];
            if(!graph.containsKey(start)) {
                graph.put(start, new HashSet<>());
            }
            graph.get(start).add(end);
        }
        boolean[] path = new boolean[numCourses]; 
        boolean[] visited = new boolean[numCourses];
        for(int key: graph.keySet()) {
            if(isCycle(key, graph, path, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCycle(int key, Map<Integer,Set<Integer>> graph, boolean[] path,boolean[] visited) {
        if(visited[key]) return false;
        if(path[key]) return true;
        if(!graph.containsKey(key)) return false;
        path[key] = true;
        boolean ret = false;
        for(Integer next : graph.get(key)){
            ret = isCycle(next, graph, path, visited);
            if(ret) {
                break;
            }
        }
        path[key] = false;
        visited[key] = true;
        return ret;
    }
}
