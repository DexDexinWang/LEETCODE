package generator;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill test = new FloodFill();
		test.floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
		
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rowLen = image.length;
        int colLen = image[0].length;
        int target = image[sr][sc];
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(sr, sc));
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!que.isEmpty()) {
            int size = que.size();
            for(int i = 0 ; i < size; i++) {
                Point p = que.poll();
                for(int[] dir : dirs) {
                    int row = p.row + dir[0];
                    int col = p.col + dir[1];
                    if (row >= 0 && row < rowLen && col >=0 && col < colLen && !visited[row][col]) {
                        if (image[row][col] == target) {
                            que.offer(new Point(row, col));
                            image[row][col] = newColor;
                        }
                        visited[row][col] = true;
                    }
                }
            }
        }
        return image;
    }
	//Time complextiy O(n) where n is the size of iamge;
	//Space complexity O(n)
}

class Point{
    int row;
    int col;
    public Point (int row, int col) {
        this.row = row;
        this.col = col;
    }
}