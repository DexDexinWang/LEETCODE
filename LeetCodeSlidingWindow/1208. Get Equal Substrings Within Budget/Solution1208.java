
public class Solution1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution1208().equalSubstring("abcd", "cdef", 3);
	}
    //SW represents the substring that is smaller or equals to maxCost
    //SW will be reduced when the cost is higher than maxCost 
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int max = 0;
        int currSumCost = 0;
        while(right < s.length()) {
            currSumCost += Math.abs(s.charAt(right) - t.charAt(right));
            while(currSumCost > maxCost) {
                currSumCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
