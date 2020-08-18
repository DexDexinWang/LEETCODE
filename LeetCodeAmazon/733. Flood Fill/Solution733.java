import java.util.Deque;
import java.util.LinkedList;

public class Solution733 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution733().floodFill1(new int[][] {{0,0,0},{0,1,1}}, 1, 1, 1);
	}
    //BFS
    //The initial node£º image[sr][sc]
    //Generate nodes by each expanded nodes: 4 directions of image[sr][sc] that value is the same as image[sr][sc]
    //Termination rules: no nodes could be expended.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length ==0) return new int[][]{};
        int rowLen = image.length;
        int colLen = image[0].length;
        Deque<int[]> que = new LinkedList<>();
        que.offerLast(new int[]{sr,sc});
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[sr][sc] = true;
        int originalValue = image[sr][sc];
        while(!que.isEmpty()) {
            int[] curr = que.pollFirst();
            image[curr[0]][curr[1]] = newColor;
            for(int i = 0; i < 4; i++) {
                int newX = directions[i][0] + curr[0];
                int newY = directions[i][1] + curr[1];
                if(isValid(image, newX, newY, originalValue, visited)) {
                    que.offerLast(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return image;
    }
    
    public boolean isValid(int[][] image, int x, int y, int target,boolean[][] visited) {
        int rowLen = image.length;
        int colLen = image[0].length;
        return x >= 0 && x < rowLen && y >=0 && y < colLen && image[x][y] == target && !visited[x][y];
    }

    //DFS 
    //How many Levels: m*n
    //How many status: 4
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        floodFillBFS(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }
    
    public void floodFillBFS(int[][] image, int x, int y, int newColor, int oldColor, boolean[][] visited) {
        image[x][y] = newColor;
        visited[x][y] = true;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        for(int i = 0; i < 4; i++) {
            int newX = directions[i][0] + x;
            int newY = directions[i][1] + y;
            if(isValid(image, newX, newY, oldColor, visited)) {
                floodFillBFS(image, newX, newY, newColor, oldColor,visited);
            }
        }
    }
    
}
