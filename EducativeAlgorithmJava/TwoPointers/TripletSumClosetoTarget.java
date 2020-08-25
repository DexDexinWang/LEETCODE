
public class TripletSumClosetoTarget {

	public static void main(String[] args) {
	}
	 public static int searchTriplet(int[] arr, int targetSum) {
		    int res = -1;
		    int len = arr.length;
		    int close = Integer.MAX_VALUE;
		    for(int i = 0; i < len; i++) {
		      int currentClose = close(i + 1, arr, targetSum -arr[i]);
		      close = Math.abs(currentClose) < Math.abs(close) ? close : currentClose;
		    }
		    return close;
		  }

		  public static int close(int left, int[] arr, int target) {
		    int right = arr.length - 1;
		    int res = Integer.MAX_VALUE;
		    while(left <= right) {
		      int temp = arr[left] + arr[right];
		      res = Math.abs(temp - target) < Math.abs(res) ?  temp - target : res;
		      if (temp == target) {
		        return 0;
		      } else if (temp < target) {
		        left++;
		      } else {
		        right --;
		      }
		    }
		    return res;
		  }
}
