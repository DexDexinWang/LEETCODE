import java.util.HashSet;
import java.util.Set;

public class Solution5216 {
/**
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 

Constraints:

1 <= n <= 2 * 10^4
 * @param args
 */
	public static void main(String[] args) {
		Solution5216 test = new Solution5216();
		int a = test.countVowelPermutation(2);

	}

	 public int countVowelPermutation(int n) {
	        Set<String> res = new HashSet<String>();
	        if (n > 0) {
	            countProcess(n, 1, "a", res);
	            countProcess(n, 1, "e", res);
	            countProcess(n, 1, "i", res);
	            countProcess(n, 1, "o", res);
	            countProcess(n, 1, "u", res);
	        }
	        
	        return res.size();
	    }
	    
	    public void countProcess(int n, int index, String current, Set<String> res) {
	        if (index == n) {
	            res.add(current);
	        } else {
	            char previous = current.charAt(current.length() - 1);
	            if (previous == 'a') {
	                countProcess(n,  index + 1,  current + 'e', res);
	            }
	            if (previous == 'e') {
	                countProcess(n,  index + 1,  current + 'a', res);
	                countProcess(n,  index + 1,  current + 'i', res);
	            }
	            if (previous == 'i') {
	                countProcess(n,  index + 1,  current + 'a', res);
	                countProcess(n,  index + 1,  current + 'e', res);
	                countProcess(n,  index + 1,  current + 'o', res);
	                countProcess(n,  index + 1,  current + 'u', res);
	            }
	            if (previous == 'o') {
	                countProcess(n,  index + 1,  current + 'i', res);
	                countProcess(n,  index + 1,  current + 'u', res);
	            }
	            if (previous == 'u') {
	                countProcess(n,  index + 1,  current + 'a', res);
	            }
	        }
	    }
}
