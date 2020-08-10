import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution886 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution886().possibleBipartition(4,new int[][] {{1,2},{1,3},{2,4}});
	}
	public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge: dislikes) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new LinkedList<>());
            graph.putIfAbsent(b, new LinkedList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        boolean[] visited = new boolean[N+1];
        
        for(int i = 1; i <= N; i++) {
            Deque<Integer> que = new LinkedList<>();
            que.offerFirst(i);
            if (visited[i])  continue;
            visited[i] = true;
            set1.add(i);
            while(!que.isEmpty()) {
                int curr = que.pollLast();
                Set<Integer> currSet = set1.contains(curr) ? set1 : set2;
                Set<Integer> nextSet = set1.contains(curr) ? set2 : set1;
                if(graph.containsKey(curr)) {
                    for(int next: graph.get(curr)) {
                        if(currSet.contains(next)){
                            return false;
                        }else if (nextSet.contains(next)) {
                            continue;
                        } else {
                            visited[next] = true;
                            nextSet.add(next);
                            que.offerLast(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}
