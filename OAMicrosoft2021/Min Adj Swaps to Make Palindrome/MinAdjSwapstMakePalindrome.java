import java.util.HashMap;
import java.util.Map;

public class MinAdjSwapstMakePalindrome {

	//Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.

	/*
	 * 
		xample 1:
		Input: "mamad"
		Output: 3
		Example 2:
		
		Input: "asflkj"
		Output: -1
		Example 3:
		
		Input: "aabb"
		Output: 2
		Example 4:
		
		Input: "ntiin"
		Output: 1
		Explanation: swap 't' with 'i' => "nitin"
	 * */
	
	// In my opnion, I prefer to solve it as greedy algorithm which should find min-distance charactere to map to the correct position.  
	
	//In my personal solution, I will first to check the frequency of the characters
	//If there is 1 character with odd frequency and others are even characters that will be fine. 
	//If all characters have the even frequencies. that will be fine. 
	
	// Next, traverse all characters with 2 pointers. 
	// initial situation: i = 0; j = len -1;
	// If string[i] == string[j] then shrink i and j as i++ and j--;
	// If string[i] != string[j] find character string[n] from [i+1 to j-1] which is euqal to string[i]. If yes. swap string[n] to string[j]
	//                                                                                                   else swap string[i] and string[i+1] 
	
	// Time complexity: O(n + n^2) space complexity: O(n)  where n is the length of the string. 
	// The space complexity could be optimized, but it may cost more time to traverse invalid string. 
	
	public int getMinAdjSwapstMakePalindrome(String str) {
		if (str == null || str.length() <=1) {
			return 0;
		}
		char[] chars = str.toCharArray();
		
		if(!validatePalidrome(chars)) {
			return -1;
		}
		int i = 0; 
		int j = str.length() - 1;
		int sum = 0;
		while (i < j) {
			while(chars[i] != chars[j]) {
				int targetIndex = findCharacter(chars, i, j);
				if(targetIndex == i) {
					swap(chars, i, i+1);
					sum++;
				} else {
					while(targetIndex < j) {
						swap(chars, targetIndex, targetIndex + 1);
						sum++;
						targetIndex++;
					}
				}
			}
			i++;
			j--;
		}
		return sum;
	}
	
	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	
	private int findCharacter(char[] chars, int i, int j) {
		while(i < j && chars[j] != chars[i]) {
			j--;
		}
		return j;
	}
	
	private boolean validatePalidrome(char[] chars) {
		int odd = 0;
		HashMap<Character, Integer> counter = new HashMap<>();
		
		for(char c : chars) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}
		for(Map.Entry<Character, Integer> element : counter.entrySet()) {
			if(element.getValue() % 2 == 1) {
				if(odd == 1) {
					return false;
				} else {
					odd++;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		MinAdjSwapstMakePalindrome test = new MinAdjSwapstMakePalindrome();
		int res = test.getMinAdjSwapstMakePalindrome("mamad");
		System.out.println(res);
		double random = Math.random() * 49 + 1;

	}

}
