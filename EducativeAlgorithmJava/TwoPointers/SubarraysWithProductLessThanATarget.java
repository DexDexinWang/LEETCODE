import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubarraysWithProductLessThanATarget {

	public static void main(String[] args) {
		System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
	}
	
 	// TODO Auto-generated method stub
	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
      List<List<Integer>> subarrays = new ArrayList<>();
      int product = 1;
      int left = 0;
      for(int right = 0; right < arr.length; right++) {
        product *= arr[right];
        while(product >= target && left < arr.length) 
          product /= arr[left++];
        List<Integer> temp = new LinkedList<>();
        for(int i = right; i >= left; i--) {
          temp.add(0,arr[i]);
          subarrays.add(new LinkedList<>(temp));
        }
        
      }
	return subarrays;
	}

}
