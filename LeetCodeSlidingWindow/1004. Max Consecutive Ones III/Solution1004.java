
public class Solution1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Sliding window represents the flexiable length of k + number of 1s
    //The sliding windows will be shinked if the current range is bigger than  k + number of 1s.
    //The final result will be the maximum length of the range.
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int[] count = new int[2];
        int left = 0;
        int right = 0;
        int currentMax = 0;
        int longest = 0;
        while(right < A.length) {
            int curr = A[right];
            count[curr]++;
            currentMax = Math.max(currentMax, count[1]);
            while(right - left + 1 > currentMax + K) {
                count[A[left++]]--;
            }
            longest = Math.max(longest, right - left + 1);
            right ++;
        }
        return longest;
    }
}
