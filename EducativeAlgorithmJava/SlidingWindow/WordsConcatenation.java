import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordsConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findWordConcatenation("catfoxcat",new String[] {"cat","fox"});
	}
	  //Sliding WIndow
	  //the window range will contains characters that has the same length with all given words.
	  //The range will be reduced if a character is added to the range. 
	  public static List<Integer> findWordConcatenation(String str, String[] words) {
	    List<Integer> resultIndices = new ArrayList<Integer>();
	    Map<Character, Integer> count = new HashMap<>();
	    Set<String> wordsSet = new HashSet<>();
	    for(String word: words) {
	      for(char c: word.toCharArray()) {
	        count.put(c, count.getOrDefault(c,0) + 1);
	      }
	      wordsSet.add(word);
	    }
	    int wordLen = words[0].length();
	    int totalSize = wordLen * words.length;

	    int totalMatched = 0;
	    int left = 0;
	    int right = 0;
	    
	    while(right < str.length()) {
	      char curr = str.charAt(right);
	      if(count.containsKey(curr)){
	        if(count.get(curr) == 1) {
	          totalMatched++;
	        }
	        count.put(curr,count.get(curr) -1);
	      }
	      if(right - left + 1 > totalSize) {
	        char tempLeft = str.charAt(left);
	        if(count.containsKey(tempLeft)) {
	          if(count.get(tempLeft) == 0) {
	            totalMatched--;
	          }
	          count.put(tempLeft, count.get(tempLeft) + 1);
	        }
        left ++;
	      }

	      if(totalMatched == count.size()) {
	        if(isWordMatched(str, left, right, wordLen, wordsSet)) {
	          resultIndices.add(left);
	        }
	      }
      right ++;
	    }
	    
	    return resultIndices;
	  }

	  private static boolean isWordMatched(String str, int i, int j, int wordLen, Set<String> wordsSet){
	    Set<String> compareSet = new HashSet<>();
	    while(i <= j - wordLen + 1) {
	      String temp = str.substring(i, i + wordLen);
	      if(wordsSet.contains(temp)) {
	        compareSet.add(temp);
	      } else {
	    	  return false;
	      }
	      i=i+wordLen;
	    }
	    return compareSet.size() == wordsSet.size();
	  }
}
