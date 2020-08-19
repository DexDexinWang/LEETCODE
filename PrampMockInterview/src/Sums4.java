import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sums4 {

	public static void main(String[] args) {
		findArrayQuadruplet(new int[] {4,4,4,4},16);

	}
	  //We could solve this problem with 2sum ideas such as that HashMap<int Sum, int[] index>
	  static int[] findArrayQuadruplet(int[] arr, int s) {
	    if(arr == null || arr.length == 0) return new int[]{};
	    Arrays.sort(arr);
	    Map<Integer, int[]> map = new HashMap<>();
	    for(int i = 1; i < arr.length; i++) {
	      for(int j = 0; j < i; j++) {
	        int sum = arr[i] + arr[j];
	        int diff = s - sum;
	        if(map.containsKey(diff) && map.get(diff)[1] < j) {
	          int[] curr = map.get(diff);
	          return new int[]{arr[curr[0]],arr[curr[1]],arr[j], arr[i]};
	        } else {
	          if(!map.containsKey(diff)) {
	            map.put(sum, new int[]{j, i});
	          }
	        }
	      }
	    }
	    return new int[]{};
	  }
}
