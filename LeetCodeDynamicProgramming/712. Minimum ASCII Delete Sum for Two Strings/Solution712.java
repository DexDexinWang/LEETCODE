
public class Solution712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP[i][j] represent how many values that will make s1.substring(0,i-1) == s2.substring(0,j-1)
    //DP[0][0] = 0;
    //DP[i][j] = dp[i-1][j-1] if s1.charAt(i-1) == s2.charAt(j-1); 
    //DP[i][j] = Math.min(dp[i-1][j] + c1[i-1], dp[i][j -1] + c2[j-1]);
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <=len1; i++) {
            dp[i][0] = dp[i-1][0] + c1[i - 1];
        }
        for(int j = 1; j <=len2; j++) {
            dp[0][j] = dp[0][j-1] + c2[j-1];
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(c1[i-1] == c2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + c1[i-1], dp[i][j -1] + c2[j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
