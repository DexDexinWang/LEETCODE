import java.util.Deque;
import java.util.LinkedList;

public class Solution1498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //SW with flexible range stastifed 
    //SW will move left side if the range is not stasfied
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int left = 0, right = 0, res = 0;
        while(right < nums.length) {
            while(!max.isEmpty() && nums[max.peekLast()] <= nums[right]) max.pollLast();
            while(!min.isEmpty() && nums[min.peekLast()] >= nums[right]) min.pollLast();
            min.offerLast(right);
            max.offerLast(right);
            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if(min.peekFirst() == left) min.pollFirst();
                if(max.peekFirst() == left) max.pollFirst();
                left++;
            }
            res = Math.max(right - left + 1, res);
            right++;
        }
        return res;
    }
}
