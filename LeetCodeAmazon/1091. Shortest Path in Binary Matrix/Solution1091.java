import java.util.Deque;
import java.util.LinkedList;

public class Solution1091 {

	public static void main(String[] args) {
		new Solution1091().shortestPathBinaryMatrix(new int[][] {{1,0},{0,1}});
		
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
        	return -1;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen]; 
        Deque<int[]> que = new LinkedList<>();
        que.offerLast(new int[] {0,0});
        visited[0][0] = true;
        int[][] directions = new int[][] {{1,0},{1,1},{0,1},{-1,0},{-1,-1},{0,-1},{1,-1},{-1,1}};
        int step = 1;
        while(!que.isEmpty()) {
        	int size = que.size();
        	for(int i = 0; i < size; i++) {
        		int[] curr = que.pollFirst();
        		if(curr[0] == rowLen -1 && curr[1] == colLen - 1) return step;
        		for(int j = 0; j<8; j++) {
        			int newX = curr[0] + directions[j][0];
        			int newY = curr[1] + directions[j][1];
        			if(newX >= 0 && newX < rowLen && newY >=0 && newY < colLen && !visited[newX][newY] && grid[newX][newY] == 0) {
        				visited[newX][newY] = true;
        				que.offerLast(new int[] {newX, newY});
        			}
        		}
        	}
        	step++;
        }
        return -1;
    }
}
