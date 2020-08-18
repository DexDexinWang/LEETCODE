import java.util.Deque;
import java.util.LinkedList;

public class Solution994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS
    //Init nodes to be expanded: all 2
    //Generate new nodes: if 4 directions of node-2 with value 1 and not visited;
    //
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        Deque<int[]> que = new LinkedList<>();
        int round = 0;
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == 2) {
                    que.offerLast(new int[]{i,j});
                }
            }
        }
        
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int[] curr = que.pollFirst();
                for(int j = 0; j < 4; j++) {
                    int newX = directions[j][0] + curr[0];
                    int newY = directions[j][1] + curr[1];
                    if(isValid(grid, visited, newX, newY)) {
                        que.offerLast(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            if(que.size()!= 0) round++;
        }
        
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return round;
    }
    
    public boolean isValid(int[][] grid, boolean[][] visited, int x, int y) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return x >=0 && y >= 0 && x < rowLen && y < colLen && !visited[x][y] && grid[x][y] == 1;
    }
    
}
