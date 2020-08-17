
public class Solution1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //bruteforce: check min length from text1 and text2, check an subsequece of min len string in another string. 
    //Time complexity: O(n! * m ) where n is the min len string, m is another string.
    
    //DP problem:  dp[i][j] represents how many characters are the same in s1 from 0 to i and in s2 from 0 to j 
    //base case dp[0][0] = 0 means get nothing from 2 strings
    //Induction rule dp[i][j] = dp[i-1][j-1] + 1 if text1.charAt(i+1) == text2.charAt(j+1)
    //Otherwise dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1.charAt(i+1) != text2.charAt(j+1) 
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        for(int i = 1; i <= len1 ; i ++) {
            for(int j = 1; j <= len2; j++) {
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
