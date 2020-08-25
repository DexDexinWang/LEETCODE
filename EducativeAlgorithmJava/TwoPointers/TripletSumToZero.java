import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSumToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
		    List<List<Integer>> triplets = new ArrayList<>();
		    int len = arr.length;
		    for(int i = 0; i < len - 2; i++){
		      if(i > 0 && arr[i] == arr[i-1]) continue;
		      int target = - arr[i];
		      findPair(i+1, len - 1, target, triplets, arr);
		    }
		    // TODO: Write your code here
		    return triplets;
		  }
	  
	  public static void findPair(int left, int right, int target, List<List<Integer>> res, int[] arr) {
		  while(left <= right) {
			  if(arr[left] + arr[right] == target) {
				  res.add(Arrays.asList(new Integer[] {-target, arr[left], arr[right]}));
				  while(left < right && arr[right] == arr[right - 1]) right--;
				  while(left < right && arr[left] == arr[left + 1]) left++;
          right--;
          left++;
			  } else if (arr[left] + arr[right] < target) {
				  left++;
			  } else {
				  right--;
			  }
		  }
	  }
}
