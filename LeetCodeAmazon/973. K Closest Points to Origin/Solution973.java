import java.util.PriorityQueue;

public class Solution973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0 || points[0].length == 0) return new int[][]{};
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[2] - a[2]));
        for(int[] point: points) {
            int[] res = new int[]{point[0], point[1], calculateDistinct(point)};
            maxHeap.offer(res);
            if(maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++) {
            int[] temp = maxHeap.poll();
            res[i] = new int[]{temp[0], temp[1]};
        }
        return res;
    }
    
    public int calculateDistinct(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
