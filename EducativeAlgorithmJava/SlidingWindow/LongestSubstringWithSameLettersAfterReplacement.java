
public class LongestSubstringWithSameLettersAfterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LongestSubstringWithSameLettersAfterReplacement().findLength("abbcb", 1);
	}
	  public static int findLength(String str, int k) {
		    if(str == null || str.length() ==0) return 0;
		    int left = 0;
		    int right = 0;
		    int[] count = new int[26];
		    int maxLen = 0;
		    int currMax = 0;
		    while(right < str.length()){
		      char temp = str.charAt(right);
		      count[temp - 'a']++;
		      currMax = Math.max(currMax, count[temp - 'a']);
		      if(right - left + 1 - currMax > k) {
		        char temp1 = str.charAt(left++);
		        count[temp1 - 'a']--;
		      }
		      maxLen = Math.max(maxLen, right - left + 1);
		      right++;
		    }
		    return maxLen;
		  }
}
