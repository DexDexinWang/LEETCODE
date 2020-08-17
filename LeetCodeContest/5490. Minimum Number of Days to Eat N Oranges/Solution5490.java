import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution5490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS
    public int minDays2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{1,1});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[0] == n) return curr[1];
            int steps = curr[1] + 1;
            int e1 = curr[0] + 1;
            int e2 = curr[0] * 2;
            int e3 = curr[0] * 3;
            if(e1 < n) {
            	queue.offer(new int[]{e1, steps});
                if(e2 < n) {
                	queue.offer(new int[]{e2, steps});
                    if(e3 < n) {
                    	queue.offer(new int[]{e3, steps});
                    }
                } 
            }
        }
        return -1;
    }
	//DP
    public int minDays1(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n+1]; 
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n + 1; i++) {
        	int e1 = dp[i-1];
        	int e2 = i % 2 == 0 ? dp[n/2]: n+1;
        	int e3 = i % 3 == 0 ? dp[n/3]: n+1;
        	dp[i] = 1 + Math.min(Math.min(e1, e2),e3);
        }
        return dp[n];
    }
	//BFS
    public int minDays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b)->(a[1] == b[1] ? b[0] - a[0]: a[1] - b[1]));
        maxHeap.offer(new int[]{1,1});
        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int steps = curr[1] + 1;
            int e1 = curr[0] + 1;
            int e2 = curr[0] * 2;
            int e3 = curr[0] * 3;
            if(e1== n || e2 == n || e3 == n) {
                return steps;
            } else {
                if(e1 < n) {
                    maxHeap.offer(new int[]{e1, steps});
                    if(e2 < n) {
                        maxHeap.offer(new int[]{e2, steps});
                        if(e3 < n) {
                            maxHeap.offer(new int[]{e3, steps});
                        }
                    } 
                }
            }
        }
        return -1;
    }
    
    private int dfs(int n) {
        if(n == 0) {
            return 0;
        }
        int eat1 = dfs(n - 1);
        int eat2 = n%2 == 0 ? dfs(n/2): Integer.MAX_VALUE;
        int eat3 = n%3 == 0 ? dfs(n/3): Integer.MAX_VALUE;
        return 1 + Math.min(Math.min(eat1,eat2),eat3);
    }
    
}
