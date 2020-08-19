
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public String longestPalindrome(String s) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < s.length(); i++) {
            res = longestPalindromeChecker(s, i, i, res); 
            res = longestPalindromeChecker(s, i, i+1, res);
        }
        return res;
    }
    
    public String longestPalindromeChecker(String s, int i, int j, String res) {
        int count  = 0;
        while (i>= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count+=2;
            i--;
            j++;
        }
        if(count > res.length()) {
            return s.substring(i + 1, j);
        }
        return res;
    }
}
