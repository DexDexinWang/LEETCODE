
public class Solution70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    //Dp[0] = 0;
	    //DP[i] = dp[i -2] + dp[i-1];
	    public int climbStairs(int n) {
	        if(n <= 2) return n;
	        int first = 1;
	        int second = 2;
	        for(int i = 3; i <= n; i++) {
	            int total = first +second;
	            first = second;
	            second = total;
	        }
	        return second;
	    }
}
