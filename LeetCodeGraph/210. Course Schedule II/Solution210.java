import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Solution210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution210 s = new Solution210();
		s.findOrder2(2, new int[][]{{1,0},{0,1}});
	}
    //Best First Search - Topological Ordering: How many in/out for each node.
    //Choose 0 in-degree node to do expend
    //Generate all neighbors which are 1 in-degree
    //Terminate not expendable
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inCount = new int[numCourses];
        for(int[] relation: prerequisites) {
            int in = relation[0];
            int out = relation[1];
            if(!graph.containsKey(out)) {
                graph.put(out, new HashSet<>());
            }
            graph.get(out).add(in);
            inCount[in]++;
        }
        int[] res = new int[numCourses];
        int index = 0;
        
        //add 0 in-degree node into que.
        Deque<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inCount[i] == 0) {
                que.offerLast(i);
                res[index++] = i;
            }
        }
        
        
        //BFS2 search
        while(!que.isEmpty()) {
            Integer curr = que.pollFirst();
            if(graph.containsKey(curr)){
                for(Integer nei: graph.get(curr)) {
                    inCount[nei] --;
                    if(inCount[nei] == 0) {
                        res[index++] = nei;
                        que.offerLast(nei);
                    }
                }
            }
        }
        
        if(index != numCourses) {
            return new int[0];
        }
		return res;
        
    }
    
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inCounter = new int[numCourses];
        for(int[] pre : prerequisites) {
            int end = pre[0];
            int begin = pre[1];
            inCounter[end]++;
            graph.putIfAbsent(begin, new HashSet<>());
            graph.get(begin).add(end);
        }
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (inCounter[i] == 0) {
                queue.offerLast(i);
            }
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            res[index++] = curr;
            if(graph.containsKey(curr)) {
                for(Integer next : graph.get(curr)) {
                    inCounter[next]--;
                    if(inCounter[next] == 0) {
                        queue.offerLast(next);
                    }
                }
            }
        }
        return res.length != numCourses ? new int[]{} : res;
    }
}
