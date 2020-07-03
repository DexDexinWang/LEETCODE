import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Directed Graph - Not DAG
    //Solution 1 : DFS + Greedy
    //Choose a node to be expanded: JFK
    //Generate next node by smallest lexical order 
    //Termination, traverse all edges.
    Map<String, List<String>> graph;
    Map<String, boolean[]> visited;
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null) return null;
        graph = new HashMap<>();
        visited = new HashMap<>();
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        
        for(Map.Entry<String, List<String>> entry: graph.entrySet()){
            Collections.sort(entry.getValue());
            int size = entry.getValue().size();
            visited.put(entry.getKey(), new boolean[size]);
        }
        
        List<String> path = new ArrayList<>();
        path.add("JFK");
        bfs2Greedy("JFK",path, tickets.size());
        return path;
    }
    
    private boolean bfs2Greedy(String airport, List<String> path, int totalFlight){
        if(path.size() == totalFlight + 1) {
            return true;
        }
        
        if(!graph.containsKey(airport)) return false;
        
        boolean[] nextVisited = visited.get(airport);
        int index = 0; 
        for(String next: graph.get(airport)){
            if(!nextVisited[index]) {
                path.add(next);
                nextVisited[index] = true;
                boolean res = bfs2Greedy(next, path, totalFlight);
                if(res) return true;
                path.remove(path.size() - 1);
                nextVisited[index] = false;
            }
            index++;
        }
        return false;
    }
}
