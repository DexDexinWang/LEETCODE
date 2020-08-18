import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP problem;
    //DP[i] represents whether the s.substring(0,i+2) are words combination
    //DP[0] = true;
    //DP[i] |= DP[k] && s.subString(k+1, k+2) is a word;
    //Time complexity: O(n^2)
    //Space complexity: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length() == 0) return true;
        Set<String> dict = new HashSet<>();
        for(String str: wordDict) {
            dict.add(str);
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for(int k = i-1; k >= 0; k--) {
                String sub = s.substring(k, i);
                if(dp[k] && dict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
