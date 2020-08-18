import java.util.Deque;
import java.util.LinkedList;

public class Solution200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS 
    //Initial Status: all lands 
    //Choose nodes to be expended: any lands 
    //Generate new nodes: all connected nodes to be connectioned. 
    //Termination Rule: there is no connected land.
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int res = 0;
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == '1') {
                    res+= checkLand(grid, visited, i , j, rowLen, colLen);
                }
            }
        }
        return res;
    }
    
    private int checkLand(char[][] grid, boolean[][] visited, int x, int y , int rowLen, int colLen) {
        if(visited[x][y]) return 0;
        Deque<int[]> que = new LinkedList<>();
        que.offerLast(new int[]{x, y});
        visited[x][y] = true;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()) {
            int[] curr = que.pollFirst();
            for(int i = 0; i < 4; i++) {
                int newX = directions[i][0] + curr[0];
                int newY = directions[i][1] + curr[1];
                if(newX >= 0 && newX < rowLen && newY >=0 && newY < colLen && !visited[newX][newY] && grid[newX][newY] == '1') {
                    que.offerLast(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return 1;
    }
}
