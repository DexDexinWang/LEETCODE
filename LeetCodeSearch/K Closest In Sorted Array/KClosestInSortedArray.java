import java.util.Arrays;

public class KClosestInSortedArray {

	public static void main(String[] args) {
		int[] res = kClosest2(new int[] {1,5}, 10,2);
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
	  
	public static int[] kClosest2(int[] array, int target, int k) {
		    //Find the most closest target. Then, it should find the next k - 1 targets 
		    if (array == null || array.length == 0 || k == 0 || array.length < k) {
		      return new int[0];
		    } 
		    int m = findClosest(array, target);
		    int l = m;
		    int r = m;
		    while (k >= 2) {
		    	if (l <= 0) {
		    		r = r + k - 1;
		    		k = 0;
		    		break;
		    	}
		    	if (r >= array.length) {
		    		l = l - k + 1;
		    		k = 0;
		    		break;
		    	}
		    	int minLeftVal = (l - k/2 + 1) > 0 ? Math.abs(target - array[l - k/2 + 1]) : Integer.MAX_VALUE;
		    	int minRightVal = (r + k/2 - 1) < array.length -1 ? Math.abs(target - array[r + k/2 - 1]) : Integer.MAX_VALUE;
		    	if (minLeftVal < minRightVal) {
		    		l = l - k/2;
		    		k = k - k/2;
		    	} else {
		    		r = r + k/2;
		    		k = k - k/2;
		    	}
		    }
		    int[] res = new int[r - l + 1];
		    while (r - l >= 0) {
		    	res[r - l] = array[r--]; 
		    }
		    return res;
	}
	
	private static void addValues(int[] to, int[] from, int i, int j, int counter) {
		
	}
	  
	  
	  
}
