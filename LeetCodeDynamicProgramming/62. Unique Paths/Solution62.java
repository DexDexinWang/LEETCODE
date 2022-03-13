
public class Solution62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    /*
    Base case: dp[0][0] = 0;
    production rule: 
    a. dp[0][j] =1; dp[i][0]=1
    b. dp[i][j] = dp[i - 1] + dp[j - 1]; 
    */
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n]; 
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
