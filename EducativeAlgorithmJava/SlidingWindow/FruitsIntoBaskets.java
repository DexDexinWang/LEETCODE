import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static int findLength(char[] arr) {
		    if(arr == null || arr.length == 0) return 0;
		    int max = 0;
		    int left = 0;
		    int right = 0;
		    Map<Character, Integer> count = new HashMap<>();
		    int basket = 0;
		    while(right < arr.length) {
		      char temp = arr[right];
		      if(!count.containsKey(temp) || count.get(temp) == 0) basket++;
		      count.put(temp, count.getOrDefault(temp,0) + 1);
		      while(basket > 2) {
		        char temp1 = arr[left];
		        count.put(temp1, count.get(temp1) - 1);
		        if(count.get(temp1) == 0) basket--;
		        left++;
		      }
		      max = Math.max(max, right - left + 1);
		      right ++;
		    }

		    return max;
		  }
}
