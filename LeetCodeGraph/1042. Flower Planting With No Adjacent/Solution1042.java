import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    //Undirected Graph with DFS
    //Each level: will consider one of [1,2,3,4] type that will not against neighbor.
	int[] res;
    public int[] gardenNoAdj(int N, int[][] paths) {
        res = new int[N];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        convertPathToGraph(graph, paths);
        boolean[] colors = new boolean[5];
        checkGarden(paths[0][0], colors, graph);
        return res;
    }
    
    public void convertPathToGraph(Map<Integer, Set<Integer>> graph, int[][] paths) {
        for(int[] dir: paths) {
            int start = dir[0];
            int end = dir[1];
            if(!graph.containsKey(start)) {
                graph.put(start, new HashSet<>());
            }
            graph.get(start).add(end);
        }
    }
    
    public void checkGarden(int current, boolean[] colors, Map<Integer, Set<Integer>> graph) {
        if(res[current - 1] != 0) return;
        int colorIndex = 1;
        while(colors[colorIndex]) {
            colorIndex++;
        }
        res[current -1 ] = colorIndex;
        Set<Integer> neighbors = graph.get(current);
        //Update Colors
        for(Integer nei : neighbors){
            int neiCol = res[nei - 1];
            if(neiCol != 0) {
                colors[neiCol] = true;
            } 
        }
        //Do neighbors;
        for(Integer nei : neighbors) {
            if(res[nei - 1] == 0) {
                boolean[] newCol = new boolean[5];
                newCol[colorIndex] = true;
                checkGarden(nei, newCol, graph);
            }
        }
    }
}
