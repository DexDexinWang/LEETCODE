import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest423 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = new Integer[]{2,5,7,8,9,2,3,4,3,1};
		List<Integer> nums = Arrays.asList(input);
		System.out.print(maxIncreasingSubarrays(nums));
	}

    // BruteForce -> check index from [0, len - k] 
    // Time complexity will be n*k space complxity will be 1
    private static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        //corner case check
        if (nums == null || nums.size() < 2 * k) return false;
        for(int i = 0; i <= nums.size() - 2 * k; i++) {
            if(adjacentChecker(nums, i, k) && adjacentChecker(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean adjacentChecker(List<Integer> nums, int currentIndex, int k) {
    	System.out.println("currentIndex:" + currentIndex);
        for(int i = currentIndex; i < currentIndex + k - 1; i++) {
            if(nums.get(i) >= nums.get(i + 1)) {
            	System.out.println("a:" + nums.get(i)+ "\t" + i);
            	System.out.println("b:" + nums.get(i+1)+ "\t" + (i+1));
                return false;
            }
        }
        
        return true;
    }

    
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int max = 0;
        for(int i = 0; i < nums.size() - max; i++) {
            int target = findMaxAdjent(nums, i);
            if (target == nums.size() - 1) {
                return (target - i + 1) /2; 
            } else if (target == -1) {
            	break;
            } else {
            	int nextTarget = findMaxAdjent(nums, target + 1);
                max = Math.max(max, Math.min(target - i, nextTarget - target));
                i = target+1;
            }       
        }
        return max;
    }

    public static int findMaxAdjent(List<Integer> nums, int curr) {
    	int target = -1;
        for(int i = curr + 1; i < nums.size(); i++) {
            if(nums.get(i - 1) < nums.get(i)) {
                target = i;
            } else {
                break;
            }
        }
        return target; 
    }
}
