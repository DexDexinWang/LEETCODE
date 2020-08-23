
public class Solution159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Sliding window with flexible range to represent the sub array that only contains 2 distinct characters
    //It will be shrinked in  a while loop if there a new distinct array is added so the array contains 3 distinct characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0; 
        int[] count = new int[100];
        int distinct = 0;
        int max = 0;
        while(right < s.length()) {
            char temp = s.charAt(right);
            count[temp - 'A']++;
            if(count[temp - 'A'] == 1) distinct++;
            while(distinct > 2) {
                char temp1 = s.charAt(left);
                count[temp1 - 'A'] --;
                if(count[temp1 -'A'] == 0) distinct--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
