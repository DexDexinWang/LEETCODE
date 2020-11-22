
public class Solution5561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int getMaximumGenerated(int n) {
        if(n==0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = i % 2 == 0 ? dp[i/2] : dp[i/2] + dp[(i/2) + 1];
            max = Math.max(max, dp[i]);
        } 
        return max;
    }
}
