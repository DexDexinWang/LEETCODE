
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP
    //Base rule: DP[0] = 1; DP[1] = 1
    //Induction rule: DP[i] = sum (DP[j -1] * DP[i - j]) where 1<= j <= i
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
    
    //G(n) function results is known as Catalan number C(n)
    //C(n+1) = 2(2n+1)*C(n) / (n+2)
    public int numTrees1(int n) {
        long c = 1;
        for(int i = 0; i < n; i++) {
            c = c * 2 * (2*i + 1) / (i + 2);
        }
        return (int)c;
    }
}
