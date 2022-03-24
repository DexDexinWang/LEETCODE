import java.util.Deque;
import java.util.LinkedList;

public class Solution785 {

	public static void main(String[] args) {
		int[][] graph = new int[][] {{1},{0,3},{3},{1,2}};
		System.out.println(new Solution785().isBipartite(graph));
	}

    //Undirected Graph solved with BFS, it should checked all nodes.
    //Choose a node to be expended. 
    //Generate new nodes by expeded nodes. 
    //Termination rule: all nodes visited.
    public boolean isBipartite(int[][] graph) {
        //0: not visited
        //1: visited in group1
        //2: visited in group2
        int[] visited = new int[graph.length];
        Deque<Integer> que = new LinkedList<>();
        for(int i =0; i < graph.length; i++) 
        {
            if(visited[i] == 0) {
                visited[i] = 1;
                que.offerLast(i);
                while(!que.isEmpty()) {
                    int size = que.size();
                    for(int j = 0; j < size; j++) {
                        int curr = que.pollFirst();
                        int group = visited[curr];
                        for(int nei: graph[curr]){
                            if(visited[nei] == 0) {
                                visited[nei] = group == 1 ? 2 : 1;
                                que.offerLast(nei);
                            } else {
                                if(visited[nei] == group) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite1(int[][] graph) {
        int len = graph.length;
        int[] visited = new int[len];
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            if(visited[i] == 0) {
                queue.offerLast(i);
                visited[i] = 1;
                if(!BfsCheck(queue,visited,graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean BfsCheck(Deque<Integer> queue, int[] visited, int[][] graph) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.pollFirst();
                int currGroup = visited[curr];
                for(int next: graph[curr]) {
                    if (visited[next] == 0) {
                        visited[next] = currGroup == 1 ? 2 : 1;
                        queue.offerLast(next);
                    } else {
                        if (visited[next]== currGroup)  {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
