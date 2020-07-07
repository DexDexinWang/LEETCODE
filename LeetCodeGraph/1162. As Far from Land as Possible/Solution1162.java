import java.util.Deque;
import java.util.LinkedList;

public class Solution1162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //BFS
    //Init node to be expanded: lands 
    //Generated nodes by expanding nodes: neighbors with updated distince
    //Termination: all node has been visited
    public int maxDistance(int[][] grid) {
        int landCount = 0;
        int n = grid.length;
        Deque<Integer[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    landCount++;
                    que.offerLast(new Integer[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        
        if(landCount == 0 || landCount == n*n) {
            return -1;
        }
        
        int res = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()) {
            Integer[] info = que.pollFirst();
            int x = info[0];
            int y = info[1];
            int distance = info[2];
            res = Math.max(res, distance);
            for(int i = 0; i < 4; i++) {
                int neiX = x + dirs[i][0];
                int neiY = y + dirs[i][1];
                if(neiX >= 0 && neiX <n && neiY >=0 && neiY < n && !visited[neiX][neiY]) {
                    que.offerLast(new Integer[]{neiX, neiY, distance + 1});
                    visited[neiX][neiY] = true;
                }
            }
        }
        return res;
    }
    
    //DP
    //DP[0][0] = 0 if it is land. Otherwise, 201 maxLength;
    //DP[i][j] = 0 if it is land. Otherwise, Math.max(DP[i-1][j], DP[i][j-1], DP[i+1][j], DP[i][j+1])+ 1; 
    public int maxDistance1(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) continue;
                grid[i][j] = 1000;
                if(i > 0) grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                if(j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
            }
        }
        int res = 0;
        for(int i = n -1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] == 1) continue;
                if(i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                if(j < n-1) grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                res = Math.max(res, grid[i][j]);
            }
        }
        return res == 1000 ? -1: res -1;
    }
}
