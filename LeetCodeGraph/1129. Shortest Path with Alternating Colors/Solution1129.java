import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS remember previous colors.
    //Choose a node to be expanded as 0,0 and 0,1 where 0 is red, 1 is blue;
    //Generated for each expanded node, with different color. 
    //Termination: all visited. 
	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, List<Integer>> graphR = new HashMap<>();
        for(int[] edge: red_edges){
            graphR.putIfAbsent(edge[0], new LinkedList<>());
            graphR.get(edge[0]).add(edge[1]);
        }
        
        Map<Integer, List<Integer>> graphB = new HashMap<>();
        for(int[] edge: blue_edges){
            graphB.putIfAbsent(edge[0], new LinkedList<>());
            graphB.get(edge[0]).add(edge[1]);
        }
        
        Deque<Integer[]> que = new LinkedList<>();
        que.offer(new Integer[]{0,1});
        que.offer(new Integer[]{0,0});
        int step = 0;
        boolean[] seenR = new boolean[n];
        seenR[0] = true;
        boolean[] seenB = new boolean[n];
        seenB[0] = true;
        
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Integer[] info = que.pollFirst();
                int orig = info[0];
                int color = info[1];
                res[orig] = res[orig] >= 0 ? Math.min(res[orig], step): step;
                Map<Integer, List<Integer>> graph = color == 0 ? graphB : graphR;
                boolean[] seen = color == 0? seenB : seenR;
                if(graph.containsKey(orig)) {
                	for(int next: graph.get(orig)) {
                		if (seen[next]) continue;
                        que.offerLast(new Integer[] {next, 1 - color});
                        seen[next] = true;
                    }
                }
            }
            step++;
        }
        return res;
    }
}
