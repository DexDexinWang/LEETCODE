import java.util.HashSet;
import java.util.Set;

public class Solution5630 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5630 test = new Solution5630();
		System.out.println(test.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
	}

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right <= nums.length - 1) {
            int curr = nums[right++];
            while(!set.add(curr)){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += curr;
            max = Math.max(sum, max);
        }
        return max;
    }
}
