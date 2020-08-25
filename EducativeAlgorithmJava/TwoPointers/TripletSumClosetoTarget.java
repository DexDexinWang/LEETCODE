import java.util.Arrays;

public class TripletSumClosetoTarget {

	public static void main(String[] args) {
		searchTriplet(new int[] {1, 0, 1, 1}, 100);
	}
	 public static int searchTriplet(int[] arr, int targetSum) {
	        Arrays.sort(arr);
			    int res = -1;
			    int len = arr.length;
			    int close = Integer.MAX_VALUE;
			    for(int i = 0; i < len; i++) {
	          int left = i + 1;
	          int right = len - 1;
	          while(left < right) {
	            int sum = arr[i] + arr[left] + arr[right];
	            close = Math.abs(targetSum - sum) < Math.abs(targetSum - close) ? sum : close;
	            if(sum == targetSum) {
	              return close;
	            } else if (sum < targetSum) {
	              left++;
	            } else {
	              right--;
	            }
	          }
			    }
			    return close;
			  }
}
