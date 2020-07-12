
public class Solution5460 {

    public int numIdenticalPairs(int[] nums) {
        int size = nums.length;
        int[] seen = new int[101];
        int res = 0;
        for(int i = 0; i < size; i++) {
            res += seen[nums[i]];
            seen[nums[i]]++;
        }
        return res;
    }
}
