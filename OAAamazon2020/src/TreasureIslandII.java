import java.util.Deque;
import java.util.LinkedList;

public class TreasureIslandII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[][] grid1=new char[][]{{'S', 'O', 'O', 'S', 'S'},
                                    {'D', 'O', 'D', 'O', 'D'},
                                    {'O', 'O', 'O', 'O', 'X'},
                                    {'X', 'D', 'D', 'O', 'O'},
                                    {'X', 'D', 'D', 'D', 'O'}};
        
        char[][] grid2=new char[][]{{'S', 'O', 'O', 'S', 'S'},
                                    {'D', 'O', 'D', 'O', 'O'},
                                    {'O', 'O', 'O', 'O', 'X'},
                                    {'X', 'D', 'D', 'O', 'O'},
                                    {'X', 'D', 'D', 'D', 'O'}};        
        int tc1 = treasureIslandII(grid1);
        int tc2 = treasureIslandII(grid2);
        if(tc1==3 && tc2==2) {
            System.out.println("All Test Case Passes!");
        } else {
            System.out.println("There are test failures!");
        }
	}
	
	public static int treasureIslandII(char[][] map) {
		if(map == null || map.length == 0 || map[0].length == 0) return -1;
		int rowLen = map.length;
		int colLen = map[0].length;
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(map[i][j] == 'S') {
					int tempRes = treasureIsland(map, i , j);
					if(tempRes != -1) Math.min(res, tempRes);
				}
			}
		}
		return res;
	}

	public static int treasureIsland(char[][] map, int x, int y) {
		int rowLen = map.length;
		int colLen = map[0].length;
		boolean[][] visited = new boolean[rowLen][colLen];
		Deque<int[]> que = new LinkedList<>();
		que.offerLast(new int[]{x,y});
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
