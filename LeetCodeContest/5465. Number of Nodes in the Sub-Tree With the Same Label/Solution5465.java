import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution5465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new Solution5465().countSubTrees(4, new int[][] {{0,2},{0,3},{1,2}}, "aeed")));
	}
	Map<Integer, List<Integer>> graph;
    List<Map<Character,Integer>> count;
    boolean[] seen;
    char[] chars;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        chars = labels.toCharArray();
        graph = new HashMap<>();
        int[] res = new int[n];
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(end, new LinkedList<>());
            graph.get(end).add(start);
            graph.putIfAbsent(start, new LinkedList<>());
            graph.get(start).add(end);
        }
        
        count = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            count.add(new HashMap<>());
            count.get(i).put(chars[i], 1);
        }
        
       seen = new boolean[n];
       seen[0] = true;
       dfs(0, - 1, res);
       return res;
    }
    
    private void dfs(int curr, int parent, int[] res){
        if(graph.containsKey(curr)) {
            for(int next: graph.get(curr)) {
                if(next == parent) continue;
                if(seen[next]) continue;
                dfs(next, curr,res);
	            mergeHashMap(count.get(next), count.get(curr));
        	}
        }
        res[curr] = count.get(curr).get(chars[curr]);
    }
    
    private void mergeHashMap(Map<Character,Integer> map1, Map<Character,Integer> map2) {
        for(Map.Entry<Character,Integer> entry : map1.entrySet()) {
            map2.put(entry.getKey(), map2.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
