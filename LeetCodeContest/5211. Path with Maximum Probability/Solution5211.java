import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution5211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS2
    //Init Node: start node
    //Generate Nodes: according to maximum pro;
    class Edge{
        int end;
        double prob;
        public Edge(int end, double prob) {
            this.end = end;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < succProb.length; i++ ) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Edge(b,succProb[i]));
            graph.get(b).add(new Edge(a,succProb[i]));
        }
        if(!graph.containsKey(start) || !graph.containsKey(end)) return 0.0;
        boolean[] visited = new boolean[n];
        //status: prob product, current, 
        PriorityQueue<Edge> maxHeap = new PriorityQueue<Edge>((Edge a,Edge b)->(a.prob > b.prob ? -1: 1));
        maxHeap.offer(new Edge(start, 1.0));
        while(!maxHeap.isEmpty()) {
            Edge curr = maxHeap.poll();
            if(visited[curr.end]) continue;
            visited[curr.end] = true;
            if(curr.end == end) return curr.prob;
            for(Edge edge: graph.get(curr.end)){
                maxHeap.offer(new Edge(edge.end, edge.prob * curr.prob));
            }
        }
        return 0.0;
    }
}
