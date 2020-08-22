
public class PermutationInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPermutation("oidbcaf","abc"));
	}
	  //The range is reduced becuase of a new character is added.
	  public static boolean findPermutation(String str, String pattern) {
	    int[] targets = new int[26];
	    int[] count = new int[26];
	    int size = pattern.length();
	    for(int i = 0; i < size; i++) {
	      targets[pattern.charAt(i) - 'a'] ++;
	    }

	    int left = 0;
	    int right = 0;
	    while(right < str.length()) {
	      char temp = str.charAt(right);
	      count[temp -'a']++;
	      if(right - left + 1 >= size) {
	        if(checkRes(targets, count)) return true;
	        char temp1 = str.charAt(left);
	        count[temp1 -'a']--;
	        left++;
	      }
	      right++;
	    }
	    return false;
	  }

	  private static boolean checkRes(int[] targets, int[] current) { 
	    for(int i = 0; i < 26; i++) {
	      if(targets[i] != current[i]) {
	        return false;
	      }
	    }
	    return true;
	  }
}
