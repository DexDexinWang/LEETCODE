import java.util.Arrays;

public class KClosestInSortedArray {

	public static void main(String[] args) {
		int[] res = kClosest(new int[] {5,2}, 2,2);
		System.out.print(Arrays.toString(res));
	}
	
	public static int[] kClosest(int[] array, int target, int k) {
	    //Find the most closest target. Then, it should find the next k - 1 targets 
	    if (array == null || array.length == 0) {
	      return null;
	    } 
	    int i = findClosest(array, target);
	    int j = i + 1;
	    int[] res = new int[k];
	    for (int l = 0; l < k ; l++) {
	      if (j > array.length - 1 || i >= 0 && Math.abs(array[i] - target) < Math.abs(array[j] - target)) {
	        res[l] = array[i--];
	      } else {
	        res[l] = array[j++];
	      }
	    }
	    return res;
	  }
	  
	  private static int findClosest(int[] array, int target) {
	    int i = 0;
	    int j = array.length - 1;
	    while (i < j - 1) {
	      int mid = i + (j - i) / 2; // find upper bound to avoid dead lock
	      if (array[mid] == target) {
	        return mid;
	      } else if (array[mid] < target) {
	        i = mid;
	      } else {
	        j = mid;
	      }
	    }
	    return Math.abs(array[i] - target) < Math.abs(array[j] - target) ? i : j;
	  }
}
