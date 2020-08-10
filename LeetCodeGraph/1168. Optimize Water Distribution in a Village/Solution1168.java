import java.util.PriorityQueue;

public class Solution1168 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Union Find + Priority Queue
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for(int i = 0; i < n; i++) minHeap.offer(new int[]{i+1, n+1, wells[i]});
        for(int[] item: pipes) minHeap.offer(item);
        int res = 0;
        int[] uf = new int[n+2];
        for(int i = 0; i < n+2; i++) uf[i] = i;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int x = find(curr[0], uf), y = find(curr[1],uf);
            if(x != y) {
                uf[x] = y;
                res+=curr[2];
            }
        }
        return res;
    }
    
    private int find(int x, int[] uf) {
        if(uf[x] != x) {
            uf[x] = find(uf[x], uf);
        }
        return uf[x];
    }
}
