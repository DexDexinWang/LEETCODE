
public class NoRepeatSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Given a string, find the length of the longest substring which has no repeating characters.
	  public static int findLength(String str) {
		    if(str == null || str.length() == 0) return 0;
		    int left = 0; 
		    int right = 0;
		    int max = 0; // How many distinct character shown once
		    int[] count = new int[26];
		    while(right < str.length()) {
		      char temp = str.charAt(right);
		      int index = temp - 'a';
		      count[index]++;
		      while(count[index] > 1) {
		        char temp1 = str.charAt(left);
		        count[temp1 - 'a']--;
		        left++;
		      }
		      max = Math.max(max, right - left + 1);
		      right++;
		    }
		    return max;
		  }
}
