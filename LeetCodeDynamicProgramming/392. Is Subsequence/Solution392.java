
public class Solution392 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Dp[0] = false;
    //DP[i] = represent whether ith character of s is in t
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int len1 = s.length();
        int len2 = t.length();
        if(len1 == 0) return true;
        if(len2 == 0 || len1 > len2) return false;
        while(j < len2 && i < len1) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            } 
            j++;
        }
        return i == len1;
    }
}
