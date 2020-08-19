import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution253 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution253().minMeetingRooms(new int[][] {{13,15},{1,13}});
	}
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for(int[] interval: intervals) {
            int b = interval[1];
            max = Math.max(max,b);
        }
        
        int[] dp= new int[max+1];
        int maxRes =0;
        for(int[] interval: intervals){
            int left = interval[0];
            int right = interval[1];
            while(left < right) {
                dp[left] += 1;
                maxRes = Math.max(maxRes, dp[left]);
                left++;
            }
        }
        return maxRes;
    }
    
    public int minMeetingRooms1(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++) {
            if(minHeap.size() != 0 && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}
