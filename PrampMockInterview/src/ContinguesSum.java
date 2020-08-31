import java.util.HashMap;

public class ContinguesSum {

	
	  public static int count(int[] input, int target) {
		    //corner case:
		    if(input == null || input.length == 0) {
		      return 0;
		    }
		    //Do presum;
		    for(int i = 1; i < input.length; i++) {
		      input[i] = input[i] + input[i-1];
		    }
		    //Define HashMap do 2 sum;
		    int res = 0;
		    HashMap<Integer, Integer> map = new HashMap<>();
		    map.put(target,1); //for single num;
		    for(int i = 0; i < input.length; i++){
		      int val = input[i];
		      if(map.containsKey(val)) {
		        res += map.get(val);
		      } 
		      map.put(val + target, map.getOrDefault(val,0)+1);
		    }
		    return res;
		  }
		  
		                
		  public static void main(String[] args) {
		    //int[] input = {9, 12, 17, 2, 4, 5};
		 //   int[] input = {9};
		     int[] input = {1,1,1,1};
		    System.out.println(count(input, 2));
		  }
}
