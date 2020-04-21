
public class Solution525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMaxLength(int[] nums) {
        //corner cases
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0;
        for(int i = 0 ; i < nums.length; i++) {
            int zeros = 0;
            int ones = 0;
            for(int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    res = Math.max(res, zeros*2);
                }
            }
        }
        return res;
    }
    //Time complexity: O(n^2) 
    //Space complexity: O(1)

}
