import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 //Solve the problem with sliding window 
	  //The range in the windows indicte the contiguous str which has the same length as patttern.
	  //The range will be reduced because of a new character is added and that range len is bigger than pattern len
	  public static List<Integer> findStringAnagrams(String str, String pattern) {
	    List<Integer> resultIndices = new ArrayList<Integer>();
	    int size = pattern.length();
	    int[] targets = new int[26];
	    for(int i = 0; i < size; i++) {
	      targets[pattern.charAt(i)- 'a']++;
	    }
	    int[] count = new int[26];
	    int left = 0;
	    int right = 0;
	    while(right < str.length()) {
	      count[str.charAt(right) - 'a']++;
	      if(right - left + 1 >= size) {
	        if(checkRes(targets, count)) resultIndices.add(left);
	        count[str.charAt(left)-'a']--;
	        left++;
	      }
	      right++;
	    }
	    return resultIndices;
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
