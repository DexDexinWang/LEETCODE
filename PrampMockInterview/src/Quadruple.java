import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quadruple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchQuadruplets(new int[] {2, 0, -1, 1, -2, 2}, 1));
	}
	  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		  Arrays.parallelSort(arr);
		    List<List<Integer>> quadruplets = new ArrayList<>();
		    int len = arr.length;
		    for(int i = 0; i < len - 3; i++) {
		      if(i>0 && arr[i-1] == arr[i]) continue;
		      for(int j = i + 1; j < len - 2; j++) {
		        if(arr[j] == arr[j-1]) continue;
		        int left = j + 1;
		        int right = len - 1;
		        
		        while (left < right) {
		          int sum = arr[i] + arr[j] + arr[left] + arr[right];
		          if(sum == target) {
		            quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
		            left++;
		            right--;
		            while(left < right  && arr[left -1] == arr[left]) left++;
		            while(left < right  && arr[right + 1] == arr[right]) right--;
		          } else if (sum < target) {
		            left++;
		          } else {
		            right--;
		          }
		        }
		      }
		    }
		    return quadruplets;
		  }
}
