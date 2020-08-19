import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Solution210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        int[] countIn = new int[numCourses];
        for(int[] relation: prerequisites) {
            int start = relation[1];
            int end = relation[0];
            if(!graph.containsKey(start)) {
                graph.put(start, new HashSet<>());
            }
            graph.get(start).add(end);
            countIn[end]++;
        }
        
        Deque<Integer> que = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;
        for(int i = 0 ; i < numCourses; i++) {
            if(countIn[i] == 0) {
                que.offerLast(i);
                res[index++] = i;
            }
        }
        
        while(!que.isEmpty()) {
            int curr = que.pollFirst();
            if(graph.containsKey(curr)){
                for(int nei: graph.get(curr)) {
                    countIn[nei] --;
                    if(countIn[nei] == 0) {
                        que.offerLast(nei);
                        res[index++] = nei;
                    }
                }
            }
        }
        if (index == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
