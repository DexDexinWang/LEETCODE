import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new	Solution56().merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
	}
    //Linear Scan and check back the previous res.
    //A kind of DP
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]));
        if(intervals == null || intervals.length <= 1) return intervals;
        Deque<int[]> stack = new LinkedList<>();
        stack.offerLast(intervals[0]);
        int index =1;
        while(index < intervals.length) {
            int[] top = stack.peekLast();
            int[] curr = intervals[index];
            if(top[1] >= curr[0]) {
                stack.offerLast(merge(stack.pollLast(), curr));
            } else {
            	stack.offerLast(curr);
            }
            index++;
        }
        int[][] res = new int[stack.size()][2];
        for(int i = stack.size()-1;i>=0;i--) {
            res[i] = stack.pollLast();
        }
        return res;
    }
    public int[] merge(int[] p1, int[] p2) {
        int start = Math.min(p1[0],p2[0]);
        int end = Math.max(p1[1], p2[1]);
        return new int[] {start, end};
    }
    
    public int[][] merge1(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b)->(a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]));
        List<int[]> tempRes = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if(end < intervals[i][0]) {
                tempRes.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        tempRes.add(new int[]{start, end});
        
        int[][] res = new int[tempRes.size()][2];
        
        return tempRes.toArray(res);
    }
}
