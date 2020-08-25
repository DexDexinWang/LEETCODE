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
	    Arrays.sort(arr);
	    List<List<Integer>> quadruplets = new ArrayList<>();
	    int len = arr.length;
	    for(int i = 0; i < len - 2; i++) {
	      if(i > 0 && arr[i-1] == arr[i]) continue;
	      for(int j = i + 1; j < len - 1; j++) {
	        if(arr[j-1] == arr[j]) continue;
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int k = j + 1; k < len; k++) {
	          if(arr[k-1] == arr[k]) continue;
	          if(map.containsKey(arr[k])) {
	            quadruplets.add(Arrays.asList(new Integer[]{arr[i], arr[j], arr[k], arr[map.get(arr[k])]}));
	          }
	          map.put(target - arr[i] - arr[j] - arr[k], k);
	        }
	      } 
	    }
	    return quadruplets;
	  }
}
