import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String findSubstring(String str, String pattern) {
	    Map<Character,Integer> count = new HashMap<>();
	    for(int i = 0; i < pattern.length(); i++) {
	      char curr = pattern.charAt(i);
	      count.put(curr, count.getOrDefault(curr,0) + 1);
	    }
	    int totalMatched = 0;
	    int left = 0;
	    int right = 0;
	    int minLen = Integer.MAX_VALUE;
      String res = "";
	    while(right < str.length()) {
	      char curr = str.charAt(right);
	      if(count.containsKey(curr)) {
	        if(count.get(curr) == 1) totalMatched ++;
	        count.put(curr,count.get(curr) - 1);
	      }
	      while(totalMatched == count.size()) {
          if(right - left + 1 < minLen) {
            minLen = right - left + 1;
            res = str.substring(left, right + 1);
          }
	        char leftCurr = str.charAt(left);
	        if(count.containsKey(leftCurr)) {
	        	count.put(leftCurr, count.get(leftCurr) + 1);
	          if(count.get(leftCurr)>0) totalMatched--;
	        }
	        left++;
	      }
	      right++;
	    }
	    return res;
	  }
}
