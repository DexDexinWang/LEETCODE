
public class Solution1456 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Sliding Window with k size 
    //SW represents the k len sub-array to count aeiou    
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while(right < s.length()) {
            count+= isVowel(s.charAt(right)) ? 1 : 0;
            if(right - left + 1 == k) {
                max = Math.max(count, max);
                count-=isVowel(s.charAt(left)) ? 1 : 0;
                left++;
            }
            right++;
        }
        return max;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
