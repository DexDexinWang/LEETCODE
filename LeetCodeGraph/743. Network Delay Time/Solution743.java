import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution743 {

	public static void main(String[] args) {
		
	}
    class Edge{
        int target;
        int distinct;
        public Edge(int target, int distinct) {
            this.target = target;
            this.distinct = distinct;
        }
    }
    //BFS2 
    //Init a node to be expanded: K
    //Generate neighbors to each node with update distinct.
    //Terminate will all nodes have been visited.
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] time: times) {
            int source = time[0];
            int target = time[1];
            int distinct = time[2];
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(new Edge(target, distinct));
        }
        
        
        
        HashMap<Integer, Integer> seen = new HashMap<>();
        
        PriorityQueue<int[]> que = new PriorityQueue<int[]>((info1, info2)->(info1[0] - info2[0]));
        que.offer(new int[]{0, K});
        while(!que.isEmpty()) {
            int[] info = que.poll();
            int target = info[1];
            int distinct = info[0];
            if(seen.containsKey(target)) continue;
            seen.put(target, distinct);
            if(graph.containsKey(target)) {
                for(Edge nei: graph.get(target)) {
                    que.offer(new int[]{nei.distinct + distinct, nei.target});
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int distinct: seen.values()){
            res = Math.max(res,distinct);
        }
        
        return seen.size() == N ? res : -1;
    }
}
