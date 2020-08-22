
public class LongestSubstringWithKDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int findLength(String str, int k) {
		if (str == null || str.length() == 0 || str.length() < k) throw new IllegalArgumentException();
	    char[] count = new char[26];
	    int left = 0;
	    int right = 0;
	    int distinct = 0;
	    int maxLen = 0;
	    while(right < str.length()) {
	      char temp = str.charAt(right);
	      int index = temp - 'a'; 
	      if(count[index] == 0) distinct++;
	      count[index]++;
	      while(distinct > k) {
	        char temp1 = str.charAt(left);
	        int index1 = temp1 - 'a';
	        count[index1]--;
	        if(count[index1] == 0) distinct--;
	        left++;
	      }
	      maxLen = Math.max(maxLen, right - left + 1);
	      right ++;
	    }
	    return maxLen;
	  }
	
}
