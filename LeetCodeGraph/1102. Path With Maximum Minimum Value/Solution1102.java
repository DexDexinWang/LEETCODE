import java.util.PriorityQueue;

public class Solution1102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = new int[][]{{5,4,5},{1,2,6},{7,4,6}};
		System.out.println(new Solution1102().maximumMinimumPath(A));
	}
	
	//BFS Find max score patch
	public int maximumMinimumPath(int[][] A) { 
        int rowLen = A.length;
        int colLen = A[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int pathMin = Integer.MAX_VALUE;
        PriorityQueue<Point> pq= new PriorityQueue<>((p1, p2)->(p2.value - p1.value));
        pq.offer(new Point(0,0,A[0][0],A[0][0]));
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()) {
            Point curr = pq.poll();
            if(curr.x == rowLen - 1 && curr.y == colLen - 1) {
                return curr.minValue;
            }
            visited[curr.x][curr.y] = true;
            for(int i= 0; i < 4; i++) {
                int neiX = curr.x + dirs[i][0];
                int neiY = curr.y + dirs[i][1];
                if(neiX>=0 && neiX < rowLen && neiY >= 0 && neiY < colLen && !visited[neiX][neiY]){
                    pq.offer(new Point(neiX, neiY, A[neiX][neiY], Math.min(curr.minValue, A[neiX][neiY])));
                }
            }
        }
        return pathMin;
    }
    
    class Point{
        int x;
        int y;
        int value;
        int minValue;
        public Point(int x, int y, int value, int minValue) {
            this.x = x;
            this.y = y;
            this.value =value;
            this.minValue= minValue;
        }
    }
}
