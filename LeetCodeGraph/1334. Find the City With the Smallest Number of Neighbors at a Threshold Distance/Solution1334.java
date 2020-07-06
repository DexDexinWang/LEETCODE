import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//new Solution1334().findTheCity(5, new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}},2);
		new Solution1334().findTheCity(6, new int[][] {{0,3,5},{2,3,7},{0,5,2},{0,2,5},{1,2,6},{1,4,7},{3,4,4},{2,5,5},{1,5,8}},8279);
	}
	
    //DP
    //DP[0][0] = Max_VALUE; 
    //DP[i][j] = min(DP[i][k] + DP[k][j]) where 0<=k<=n-1
    public int findTheCity1(int n, int[][] edges, int distanceThreshold) {
        int[][] conns = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                conns[i][j] = 9999999;
            }
        }
        for(int[] edge: edges){
            conns[edge[0]][edge[1]] = edge[2];
            conns[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    conns[i][j] = Math.min(conns[i][j], conns[i][k] + conns[k][j]);
                }
            }
        }
        
        int resCity = -1;
        int resMinNeis = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int totalNeis  = 0;
            for(int j = 0; j < n; j++) {
                if (i == j) continue;
                if (conns[i][j] <= distanceThreshold) {
                    totalNeis++;
                }
            }
            if(totalNeis <= resMinNeis) {
                resMinNeis = totalNeis;
                resCity = i;
            }
        }
        return resCity;
    }
	
	//Dijkstra Search BFS2 for each node;
	class Edge{
        int end;
        int distance;
        public Edge(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
	//Dijkstra Search BFS2 for each node;
	   public int findTheCity(int n, int[][] edges, int distanceThreshold) {
	        int minNei = Integer.MAX_VALUE;
	        int city = 0;
	        Map<Integer, List<Edge>> graph = new HashMap<>();
	        for(int[] edge: edges) {
	            int start = edge[0];
	            int end = edge[1];
	            int distance = edge[2];
	            graph.putIfAbsent(start, new ArrayList<>());
	            graph.get(start).add(new Edge(end, distance));
	            graph.putIfAbsent(end, new ArrayList<>());
	            graph.get(end).add(new Edge(start, distance));

	        }
	        
	        for(int i = 0; i < n; i++) {
	            PriorityQueue<Integer[]> pq = new PriorityQueue<>((info1, info2)->(info2[1]-info1[1]));
	            int total = -1;
	            pq.offer(new Integer[]{i, distanceThreshold});
	            boolean[] visited = new boolean[n];
	            while(!pq.isEmpty()) {
	                Integer[] info = pq.poll();
	                int start = info[0];
	                int distance = info[1];
	                if(visited[start]) continue;
	                visited[start] = true;
	                total++;
	                if(graph.containsKey(start)) {
	                    for(Edge nei: graph.get(start)) {
	                        int remaining =distance - nei.distance;
	                        if(remaining >=0) {
	                            pq.offer(new Integer[]{nei.end,remaining});
	                        }
	                    }
	                }
	            }
	            if(total <= minNei) {
	            	minNei = total;
	                city = i;
	            }
	        }
	        return city;
	    }
}
