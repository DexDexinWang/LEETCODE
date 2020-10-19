
public class Solution161 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution161().isOneEditDistance("ab","acd"));
	}
	public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if(s == null || t == null || Math.abs(sLen - tLen) > 1) // Math.abs
            return false;
        
        int left = 0;
        int right = 0;
        
        while(left < sLen && right < tLen)
        {
            if(s.charAt(left) != t.charAt(right))
            {
                return helper(s,t,left+1, right+1) || helper(s,t,left + 1, right) || helper(s,t,left, right+1);       
            }
            left++;
            right++;
        }
        
        return Math.abs(sLen - tLen) == 1;
    }
	
	boolean helper(String s, String t, int left, int right)
    {
        while(left < s.length() && right < t.length())
        {
            if(s.charAt(left) != t.charAt(right))
            {
                return false;

            }
            left++;
            right++;
        }
        
        return left == s.length() && right == t.length(); //update logic
    }

}
