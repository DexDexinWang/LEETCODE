import java.util.LinkedList;
import java.util.Queue;


public class TreasureIslandII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findShortestPathForTreasure(int[][] island) {
		int len1 = island.length; 
		int len2 = island[0].length;
		if (island == null || len2 ==0 || len1 == 0) {
			return 0;
		}
		Queue<Coordinate> queue = new LinkedList<>();
		boolean[][] visited = new boolean[len1][len2];
		int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				if (island[i][j] == 'S') {
					queue.offer(new Coordinate(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0 ; i < size ; i ++) {
				Coordinate temp =  queue.poll();
				if (island[temp.x][temp.y]=='X') {
					return steps;
				} else {
					for (int[] dir : dirs) {
						int newX = temp.x + dir[0];
						int newY = temp.y + dir[1];
						if (newX >= 0 && newX < len1 && newY >=0 && newY < len2 
								&& !visited[newX][newY] && island[newX][newY] != 'D') { 
							queue.add(new Coordinate(newX,newY));
							visited[newX][newY] = true;
						}
					}
				}
			}
			steps ++;
		}
		return 0;
		
	}
	
	static class Coordinate {
		int x;
		int y;
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
