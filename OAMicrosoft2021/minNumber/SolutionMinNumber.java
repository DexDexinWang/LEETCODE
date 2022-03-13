import java.util.HashSet;
import java.util.Set;

public class SolutionMinNumber {

	/**
	 * 
Given a string s, find the minimum number of substrings you can create without having the same letters repeating in each substring.
E.g world -> 5, as the string has no letters that occur more than once.
dddd -> 4, as you can only create substring of each character.
abba -> 2, as you can make substrings of ab, ba.
cycle-> 2, you can create substrings of (cy, cle) or (c, ycle)
	 * @param args
	 */
    public static void main(String[] args) {
        System.out.println(minNumber("cycle"));
    }
    

    public static int minNumber(String str) {
    	if(str == null || str.length() == 0) {
    		return 0;
    	}
    	
    	int index = 0;
    	int sum = 0;
    	Set<Character> set = new HashSet<>();
    	while(index < str.length()) {
    		if(set.contains(str.charAt(index))) {
    			sum++;
    			set.clear();
    		}
    		set.add(str.charAt(index));
    		index++;
    	}
    	if(!set.isEmpty()) {
    		sum++;
    	}
    	return sum;
    }
}
