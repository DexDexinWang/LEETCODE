import java.util.Deque;
import java.util.LinkedList;

public class TreasureIsland {

	public static void main(String[] args) {
		char[][] island = new char[][]{
			{'O', 'O', 'O', 'O'},
			{'D', 'O', 'D', 'O'},
			{'O', 'O', 'O', 'O'},
			{'X', 'D', 'D', 'O'}
		};
		int result = treasureIsland(island);
		System.out.println(String.format("%s (expect 5)", result));
	}

	public static int treasureIsland(char[][] map) {
		if(map == null || map.length == 0 || map[0].length == 0) return -1;
		int rowLen = map.length;
		int colLen = map[0].length;
		boolean[][] visited = new boolean[rowLen][colLen];
		Deque<int[]> que = new LinkedList<>();
		que.offerLast(new int[]{0,0});
		int step = 0;
		int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
		while(!que.isEmpty()) {
			int size = que.size();
			step++;
			for(int i = 0; i < size; i++) {
				int[] curr = que.pollFirst();
				for(int j = 0; j < 4; j++) {
					int newX = curr[0] + directions[j][0];
					int newY = curr[1] + directions[j][1];
					if(newX >= 0 && newX < rowLen  && newY >= 0 && newY < colLen && !visited[newX][newY] && map[newX][newY] != 'D') {
						if(map[newX][newY] == 'X') return step++;
						visited[newX][newY] = true;
						que.offerLast(new int[] {newX, newY});
					}
				}
			}
		}
		return -1;
	}
}
