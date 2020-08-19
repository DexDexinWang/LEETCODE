import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution15().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length <= 2) return res;
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
           if(i != 0 && nums[i - 1] == nums[i]) continue;
           Set<Integer> seen = new HashSet<>();
           for(int j = i + 1; j < n; j++) {
               int key = - nums[i] - nums[j];
               if(seen.contains(key)) {
                   res.add(Arrays.asList(nums[i], nums[j], key));
                   while(j+1 < nums.length && nums[j] == nums[j+1]) ++j;
               }
               seen.add(nums[j]);
               
           }  
        }
        return res;
    }
}
