import java.util.HashMap;
import java.util.Map;

public class WordCountEngine1 {


	  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
		    //corn case
		    if(arr.length <= 1) {
		      return new int[]{};
		    }
		    Map<Integer,Integer> map = new HashMap<>();
		    for(int i = 0; i < arr.length; i++) {
		      int remaining = limit - arr[i];
		      if(map.containsKey(remaining)) {
		        return new int[]{map.get(remaining), i};
		      }
		      map.putIfAbsent(remaining, 0);
		      map.put(remaining, map.get(remaining) + 1);
		    }
		    return new int[]{};
		  }
		  
		  public static void main(String[] args) {
		     System.out.println(Arrays.toString(getIndicesOfItemWeights(new int[]{4, 6, 10, 15, 16}, 21)));
		  }
}
