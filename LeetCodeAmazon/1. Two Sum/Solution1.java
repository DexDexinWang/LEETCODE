import java.util.HashMap;
import java.util.Map;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Perfor saving time complexity of space complexity?
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{};
        if(nums == null || nums.length <= 1) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i <nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            } 
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
