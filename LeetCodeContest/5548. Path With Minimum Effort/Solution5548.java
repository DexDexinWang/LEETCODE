import java.util.PriorityQueue;

public class Solution5548 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = new int[][] {{1,2,3},{3,8,4},{5,3,5}};
		System.out.println(new Solution5548().minimumEffortPath1(heights));
	}
	
    int globalMin;
    int rowLen;
    int colLen;
    public int minimumEffortPath(int[][] heights) {
        globalMin = Integer.MAX_VALUE;
        rowLen = heights.length;
        colLen = heights[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        dfsFindMin(heights, visited, 0,0,0);
        return globalMin;
    }
    
    public void dfsFindMin(int[][] heights, boolean[][] visited, int currX, int currY, int minDiff) {
        if(currX == rowLen -1 && currY == colLen -1) {
            globalMin = Math.min(globalMin, minDiff);
            return;
        }
        visited[currX][currY] = true;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : dirs) {
            int nextX = currX + dir[0];
            int nextY = currY + dir[1];
            if(nextX >= 0 && nextX < rowLen && nextY >=0 && nextY < colLen && !visited[nextX][nextY]) {
                int diff = Math.abs(heights[currX][currY] - heights[nextX][nextY]);
                if(diff <= globalMin) {
                    dfsFindMin(heights, visited, nextX, nextY, Math.max(diff,minDiff));
                }
            }
        }
        visited[currX][currY] = false;
    }
    
    public int minimumEffortPath1(int[][] heights) {
        int globalMin = Integer.MAX_VALUE;
        int rowLen = heights.length;
        int colLen = heights[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[2] - b[2]));
        
        minHeap.offer(new int[]{0,0,0});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currX = curr[0];
            int currY = curr[1];
            visited[currX][currY] = true;
            if(currX == rowLen -1 && currY == colLen -1) {
                globalMin = Math.min(globalMin, curr[2]);
                return globalMin;
            }
            int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] dir : dirs) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if(nextX >= 0 && nextX < rowLen && nextY >=0 && nextY < colLen && !visited[nextX][nextY]) {
                    int diff = Math.abs(heights[currX][currY] - heights[nextX][nextY]);
                    minHeap.offer(new int[]{nextX, nextY, Math.max(diff, curr[2])});
                }
            }    
        }
        return globalMin;
    }
}
