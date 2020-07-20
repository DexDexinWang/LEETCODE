import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Topological Ordering
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[N+1];
        for(int[] edge: relations) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new LinkedList<>());
            graph.get(start).add(end);
            inDegree[end]++;
        }
        Deque<Integer> que = new LinkedList<>();
        int seenSize = 0;
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                que.offerLast(i);
                seenSize++;
            }
        }
        
        int step = 0; 
        while(!que.isEmpty()) {
            int size = que.size();
            step++;
            for(int i = 0; i < size; i++) {
                int curr = que.pollFirst();
                if(graph.containsKey(curr)){
                    for(int next: graph.get(curr)) {
                        inDegree[next]--;
                        if(inDegree[next] == 0) {
                            que.offerLast(next);
                            seenSize++;
                        }
                    }
                }
            }
        }
        return seenSize == N ? step : -1;
    }
}
