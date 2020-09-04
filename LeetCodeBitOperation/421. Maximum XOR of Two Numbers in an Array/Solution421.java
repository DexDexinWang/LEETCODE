
public class Solution421 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j< n; j++) {
                max = Math.max(max,(nums[i] ^nums[j]));
            }
        }
        return max;
    }
}
