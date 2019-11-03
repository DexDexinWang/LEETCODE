import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
 * @author Dex
 *
 */
public class Solution5240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int max = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        } 
        traverse(arr, new int[26], 0);
        return max;
    }
    
    public void traverse(List<String> arr, int[] record, int index) {
        if (index == arr.size()) {
            return;
        } 
        //ignore current string;
        traverse(arr, record, index + 1);
        
        //concat current string
        // update counter;
        for(char c: arr.get(index).toCharArray()) {
            record[c - 'a'] += 1;
        }
        
        boolean isSame = false;
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (record[i] >= 1) {
                sum++;
                if (record[i] > 1) {
                    isSame = true;
                }
            }
            
        }
        
        if (!isSame) {
            max = Math.max(max, sum);
            traverse(arr, record, index + 1);
        } 
        
        //restore counter;
        for(char c: arr.get(index).toCharArray()) {
            record[c - 'a'] -= 1;
        }
    }
}
