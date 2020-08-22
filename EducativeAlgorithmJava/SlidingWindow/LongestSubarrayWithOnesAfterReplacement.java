
public class LongestSubarrayWithOnesAfterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static int findLength(int[] arr, int k) {
		    int[] count = new int[2];
		    int left = 0;
		    int right = 0;
		    int max = 0;
		    while(right < arr.length) {
		      int val = arr[right];
		      count[val]++;
		      if(right - left + 1 - count[1] > k) {
		        count[arr[left++]]--;
		      }
		      max = Math.max(max, right - left + 1);
		      right ++;
		    }
		    return max;
	  }

}
