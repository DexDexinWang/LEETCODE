import java.util.Deque;
import java.util.LinkedList;

public class Solution5602 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5602 test = new Solution5602();
		System.out.println(test.minOperations(new int[] {1,1,4,2,3}, 5));
	}
	
	
	public int minOperations(int[] nums, int x) {
		 
		Deque<int[]> queue = new LinkedList<>();
		queue.offerLast(new int[] {0, nums.length - 1, x});
		int steps = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] temp = queue.pollFirst();
				if(temp[2] == 0) return steps;
				if(temp[0] > temp[1]) return -1;
				if(temp[2] - nums[temp[0]] >= 0) {
					queue.offerLast(new int[] {temp[0] + 1, temp[1], temp[2] - nums[temp[0]]});
				}
				if(temp[2] - nums[temp[1]] >= 0) {
					queue.offerLast(new int[] {temp[0], temp[1] - 1, temp[2] - nums[temp[1]]});
				} 
			}
			steps++;
		}
		return -1;
	}
	
	
    int min;
    public int minOperations1(int[] nums, int x) {
        min = Integer.MAX_VALUE;
        bfs(nums,0,nums.length -1, x, 0);
        return min != Integer.MAX_VALUE ? min: -1;
    }
    
    public void bfs(int[] nums, int left, int right, int x, int steps) {
        if(left > right || x < 0 || steps >= min) {
            return;
        }
        if(x == 0) {
        	min = Math.min(min, steps);
            return;
        }
        
        bfs(nums, left + 1, right, x - nums[left], steps + 1);
        bfs(nums , left, right - 1, x - nums[right], steps + 1);
    }
}
