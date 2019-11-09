import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5248 {

	public static void main(String[] args) {
		Solution5248 demo = new Solution5248();
		int[] nums = new int[] {1,1,2,1,1};
		demo.numberOfSubarrays(nums, 3);
	}
	
    private Set<List<Integer>> set = new HashSet<>();
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> curr = new ArrayList<>();
        helper(nums, k, 0, curr);
        return set.size();
    }
    
    private void helper(int[] nums, int k, int index, List<Integer> curr) {
        if (index >= nums.length) {
            if (k == 0) {
                set.add(curr);
            }
            return;
        }
        //Do not add current number
        helper(nums, k, index + 1, curr); 
        
        if (! (nums[index] % 2 == 1 && k == 0)) {
            //Add current number
            curr.add(nums[index]);
            boolean isOdd = nums[index] % 2 == 1 && k > 0;
            helper(nums, k - (isOdd ? 1: 0), index + 1, curr);
            //change it back 
            curr.remove(curr.size() - 1); 
        }
    }

	
}
