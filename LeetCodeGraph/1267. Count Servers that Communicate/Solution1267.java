import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1267 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {{0,0,0,0},{1,1,1,1},{0,0,0,1},{0,0,1,1},{0,0,0,1}};
		new Solution1267().countServers1(grid);
	}
	
    public int countServers2(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] rowCount = new int[rowLen];
        int[] colCount = new int[colLen];
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int res = 0;
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1) {
                    if(rowCount[i] > 1 || colCount[j]> 1) res++;
                }
            }
        }
        return res;
    }
	
    //BFS check all nodes
    //Choose a node to be expended: not visited node
    //Generate new nodes by expended node: find computer in the same x-ray or y-ray 
    //Terminated: all nodes are visited.
    public int countServers(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < rowLen ; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1) {
                    int source = convertXYToInteger(i,j);
                    graph.putIfAbsent(source, new ArrayList<>());
                    for(int y = 0; y < colLen; y++) {
                        if(y != j && grid[i][y] == 1){
                            graph.get(source).add(convertXYToInteger(i,y));
                        }
                    }
                    for(int x = 0; x < rowLen; x++) {
                        if(x != i && grid[x][j] == 1) {
                            graph.get(source).add(convertXYToInteger(x,j));
                        }
                    } 
                }
            }
        }
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for(int key: graph.keySet()) {
            if(!seen.contains(key)) {
                res += BFS(graph, key, seen);
            }
        }
        return res;
    }
    
    private int BFS(Map<Integer, List<Integer>> graph, int curr, Set<Integer> seen) {
        int res = 0;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while(!queue.isEmpty()) {
            int orig = queue.pollFirst();
            if(seen.contains(orig)) continue;
            seen.add(orig);
            res++;
            for(int next: graph.get(orig)) {
                queue.offer(next);
            }
        }
        return res >= 2? res: 0;
    }
    
    private int convertXYToInteger(int x, int y){
        return x * 1000 + y;
    }
    
    private int[] convertIntegerToXY(int value) {
        int[] res = new int[2];
        res[1] = value%1000;
        res[0] = value/1000;
        return res;
    }
    
	
    //BFS check all nodes
    //Choose a node to be expended: not visited node
    //Generate new nodes by expended node: find computer in the same x-ray or y-ray 
    //Terminated: all nodes are visited.
    public int countServers1(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int total = 0;
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    total += BFSCheck(grid, visited, i,j,rowLen,colLen);
                }
            }
        }
        return total;
    }
    
    private int BFSCheck(int[][] grid, boolean[][] visited, int row, int col, int rowLen, int colLen) {
        int connectedComputers = 0;
        Deque<Integer[]> queue = new LinkedList<>();
        queue.offerLast(new Integer[]{row,col});
        while(!queue.isEmpty()){
            Integer[] info = queue.pollFirst();
            int xRow = info[0];
            int yCol = info[1];
            if(visited[xRow][yCol]) continue;
            connectedComputers++;
            visited[xRow][yCol] = true;
            for(int i =0; i < rowLen; i++){
                if(i != row && grid[i][yCol] == 1 && !visited[i][yCol]) {
                    queue.offer(new Integer[]{i, yCol});
                }
            }
            
            for(int j =0; j < colLen; j++){
                if(j != col && grid[xRow][j] == 1 && !visited[xRow][j]) {
                    queue.offer(new Integer[]{xRow, j});
                }
            }
        }
        return connectedComputers >= 2 ? connectedComputers: 0;
    }
}
