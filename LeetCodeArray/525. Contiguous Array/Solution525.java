import java.util.HashMap;
import java.util.Map;

public class Solution525 {

	public static void main(String[] args) {
		Solution525 test = new Solution525();
		test.findMaxLength1(new int[] {0,1,0});
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

	
    //Dp problem:
    //use counter to count 0s and 1s. If 0 then -1, otherwise 1.
    //Base case: dp[0] = 0
    //Induction rule 1: dp[i] = i + 1 when counter = 0 that indicates there are same 0s and 1s from beginning to current
    //Induction rule 2: dp[i] = i - dp[x] when counter != 0 and dp[x] = counter that indicates there are 0s and 1s from x to i - 1;
    //Speicl strcutre: find dp[0] to dp[x] will use O(n), which could be reduced by using HashMap<Integer,Integer>
    public int findMaxLength1(int[] nums) {
        //corner cases
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Map<Integer,Integer> records = new HashMap<>();
        int maxLen = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i ++) {
            counter += nums[i] == 0 ? -1: 1;
            if (counter == 0) {
                maxLen = i + 1;
            } else if (records.containsKey(counter)) {
                maxLen = Math.max(maxLen, i - records.get(counter));
            } else {
                records.put(counter, i);
            }
        }
        return maxLen;
    }
    //Time complexity: O(n) 
    //Space complexity: O(n)
}
