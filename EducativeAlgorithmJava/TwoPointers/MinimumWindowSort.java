
public class MinimumWindowSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static int sort(int[] arr) {
		    int len = arr.length;
		    int low = 0;
		    while (low < len - 1 && arr[low] <= arr[low + 1]) {
		      low++;
		    }
		    if(low == arr.length - 1) return 0;
		    int high = len - 1;
		    while (high > 0 && arr[high - 1] <= arr[high]) {
		      high--;
		    }
		    int min = Integer.MAX_VALUE;
		    int max = Integer.MIN_VALUE;
		    for(int i = low; i <= high; i++) {
		      min =Math.min(min, arr[i]);
		      max =Math.max(max, arr[i]);
		    }
		    while (low > 0 && arr[low - 1] > min) {
		      low--;
		    }
		    while (high < len - 1 && arr[high + 1] < max) {
		      high++;
		    }
		    return high - low + 1;
		  }
}
