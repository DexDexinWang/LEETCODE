import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution1494 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1494().minNumberOfSemesters(12, new int[][] {{11,10},{6,3},{2,5},{9,2},{4,12},{8,7},{9,5},{6,2},{7,2},{7,4},{9,3},{11,1},{4,3}}, 3));
	}	
	
	//Topological Graph with BFS2 that consider depth.  
	
	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for(int[] edge : dependencies) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new LinkedList<>());
            graph.get(start).add(end);
            inDegrees[end]++;
            outDegrees[start]++;
        }
        
        Map<Integer, Integer> depth = new HashMap<>();
        for(int i = 1; i <= n; i++) {
        	depth.put(i,getDepth(i,graph, 0));
        	/*
        	if(!depth.containsKey(i)) {
        		boolean[] path = new boolean[n+1];
        		if(updateDepth(i, graph, depth, path) == -1) {
        			return -1;
        		}
        	}
        	*/
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(depth.get(b) == depth.get(a) ? outDegrees[b] - outDegrees[a] :depth.get(b) - depth.get(a)));
        
        int seenSize = 0; 
        for(int i = 1; i <= n; i++) {
            if(inDegrees[i] == 0) {
                maxHeap.offer(i);
                seenSize++;
            }
        }
        
        int step = 0;
        while(!maxHeap.isEmpty()) {
        	step++;
            Deque<Integer> que = new LinkedList<>();
            for(int i = Math.min(k, maxHeap.size()); i > 0; i--) {
                que.offerLast(maxHeap.poll());
            }
            while(!que.isEmpty()) {
            	
                int curr = que.pollFirst();
                if(graph.containsKey(curr)) {
                    for(int next : graph.get(curr)){
                        if(--inDegrees[next] == 0) {
                            maxHeap.offer(next);
                            seenSize++;
                        }
                    }
                }
            }
        }
        return seenSize == n ? step: -1;
    }
	
	private int getDepth(int course, Map<Integer, List<Integer>> map, int currDepth){
        if(map.containsKey(course)){
            for(int neighbor : map.get(course)){
            	int temp = getDepth(neighbor, map, currDepth + 1);
                return Math.max(currDepth, temp);
            }
        }
        return currDepth;
    }
	
	private int updateDepth(int curr, Map<Integer,List<Integer>> graph, Map<Integer,Integer> depth,  boolean[] path) {
		if(path[curr]) return -1;
		path[curr] = true;
		int res = -1;
		if (graph.containsKey(curr)) {
			for(int next: graph.get(curr)) {
				if(depth.containsKey(next)) {
					res = Math.max(res, depth.get(next));
				} else {
					int max = updateDepth(next, graph, depth, path);
					if (max == -1) return -1;
					res = Math.max(res, updateDepth(next, graph, depth, path));
				}
			}
		} else {
			res = 0;
		}
		res+=1;
		depth.put(curr, res);
		path[curr] = false;
		return res;
	}
}
