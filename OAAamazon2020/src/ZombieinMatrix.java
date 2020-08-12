import java.util.Deque;
import java.util.LinkedList;

public class ZombieinMatrix {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(minDays(grid));
	}
	//BFS
	//Choose nodes to be expended: all zombie locations
	//Generate new Nodes: all connected humans
	//Termination: no humans.
	private static int minDays(int[][] grid) {
		int hours = 0;
		int rowLen = grid.length; 
		int colLen = grid[0].length;
		if(rowLen == 0 || colLen == 0) return hours;
		boolean[][] visited = new boolean[rowLen][colLen];
		Deque<int[]> que = new LinkedList<>();
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if (grid[i][j] == 1) {
					que.offerLast(new int[] {i,j});
				}
			}
		}
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				int[] zombie = que.pollFirst();
				int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
				for(int j = 0; j < 4; j++) {
					int newX = zombie[0] + directions[j][0];
					int newY = zombie[1] + directions[j][1];
					if(newX >= 0 && newX < rowLen && newY >= 0 && newY < colLen && !visited[newX][newY] && grid[newX][newY]== 0) {
						que.offerLast(new int[] {newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
			if(que.size() != 0) hours++;
		}
		return hours;
	}
}
