
public class Solution424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //SW represent the maximum sub-array that satisfied the requirements
    //SW will be shrinked if a new character is added. 
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] count = new int[26];
        int max = 0;
        int maxOccurance = 0;
        while(right < s.length()) {
            char temp = s.charAt(right);
            count[temp - 'A'] ++;
            maxOccurance = Math.max(maxOccurance, count[temp-'A']);
            if(right - left + 1 - maxOccurance > k) {
                count[s.charAt(left++) - 'A']--;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
