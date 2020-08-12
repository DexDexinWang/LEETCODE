import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 10, 25, 35, 60};
		int target1 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums1, target1-30)));
		int[] nums2 = {20, 50, 40, 25, 30, 10};
		int target2 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums2, target2-30)));
		int[] nums3 = {50, 20, 10, 40, 25, 30};
		int target3 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums3, target3-30)));
		int[] nums4 = {1, 2};
		int target4 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums4, target4-30)));
	}

	public static int[] Find2Sum(int[] nums, int target) {
		int[] res = new int[] {-1,-1};
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i <nums.length; i++) {
			int curr = nums[i];
			if(map.containsKey(curr)) {
				if(curr > max || nums[map.get(curr)] > max) {
					res[0] = map.get(curr);
					res[1] = i;
					max = Math.max(curr, nums[map.get(curr)]);
				}
			} 
			map.put(target - nums[i], i);
		}
		return res;
	}
}
