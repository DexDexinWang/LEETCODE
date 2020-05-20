

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame test = new JumpGame();
		test.canJump(new int[] {2,3,1,1,4});
	}

	//DP problem;
    //base case DP[len - 1] = true where len is the length of the input nums
    //induction rule: dp[i] = true where any nums[i + j] = true where nums[i] = j. 
    public boolean canJump(int[] nums) {
        //corner cases
        if (nums == null || nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }
        int len = nums.length;
        boolean[] dp = new boolean[nums.length];
        dp[len - 1] = true;
        for(int i = len - 2; i >= 0 ; i--) {
            int j = nums[i];
            if (j != 0) {
                for(int k = 1; k + i < len && k <= j; k++) {
                    if (dp[k + i]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
    //Greedy algorithm 
    public boolean canJump1(int[] nums) {
    	//corner cases
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reachable = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (reachable < i) {
        		return false;
        	} 
        	reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
