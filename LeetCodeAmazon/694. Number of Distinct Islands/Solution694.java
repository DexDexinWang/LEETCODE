import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution694 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public int numDistinctIslands(int[][] grid) {
        Set<String> sharps = new HashSet<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int i =0 ; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    String sharp = BFS(grid, visited, i, j);
                    sharps.add(sharp);
                }
            }
        }
        return sharps.size();
    }
    
    public String BFS(int[][] grid, boolean[][] visited, int x, int y) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        visited[x][y] = true;
        Deque<int[]> que = new LinkedList<>();
        int[][] directions = new int[][]{{0,-1,1},{0,1,2},{-1,0,3},{1,0,4}};
        StringBuilder sb = new StringBuilder();
        que.offerLast(new int[]{x,y});
        while(!que.isEmpty()) {
            int[] curr = que.pollFirst();
            for(int i = 0 ; i < 4 ; i++) {
                int newX = curr[0] + directions[i][0];
                int newY = curr[1] + directions[i][1];
                if(newX >= 0 && newX < rowLen && newY >=0 && newY < colLen && !visited[newX][newY] && grid[newX][newY] == 1) {
                    sb.append(directions[i][2]);
                    que.offerLast(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return sb.toString();
    }
 
	
    public int numDistinctIslands1(int[][] grid) {
        Set<String> sharps = new HashSet<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int i = 0 ; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                StringBuilder sb = new StringBuilder();
                if(!visited[i][j] && grid[i][j] == 1) {
                    sb.append("S");
                    dfs(grid, visited, i, j, sb, rowLen, colLen);
                    sharps.add(sb.toString());
                }
            }
        }
        return sharps.size();
    }

	public void dfs(int[][] grid, boolean[][] visited, int x, int y, StringBuilder sb, int rowLen, int colLen) {
	    if(visited[x][y]) return;
	    visited[x][y] = true;
	    int[][] directions = new int[][]{{-1,0,1},{0,-1,2},{0,1,3},{1,0,4}};
	    for(int i = 0 ; i < 4 ; i++) {
	        int newX = x + directions[i][0];
	        int newY = y + directions[i][1];
	        if(newX >= 0 && newX < rowLen && newY >=0 && newY < colLen && grid[newX][newY] == 1) {
	            dfs(grid, visited, newX, newY, sb, rowLen, colLen);
	            sb.append(directions[i][2]+"");
	        }
	    }
	}
}
