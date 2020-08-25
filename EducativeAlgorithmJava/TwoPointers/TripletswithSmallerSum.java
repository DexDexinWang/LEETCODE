import java.util.Arrays;

public class TripletswithSmallerSum {
	  public static int searchTriplets(int[] arr, int target) {
		    Arrays.sort(arr);
		    int count = 0;
		    for(int i = 0; i < arr.length; i++) {
		      int left = i + 1;
		      int right = arr.length - 1;
		      while(left < right) {
		        int sum = arr[i] + arr[left] + arr[right];
		        if(sum < target ) {
		          count+=right - left;
		          left++;
		        }  else {
		          right --;
		        }
		      }
		    }
		    return count;
		  }
}
