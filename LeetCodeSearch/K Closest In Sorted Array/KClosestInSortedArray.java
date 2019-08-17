
public class KClosestInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] kClosest(int[] array, int target, int k) {
	    if (array == null || array.length == 0) {
	      return new int[0];
	    }
	    int left = closest(array, target);
			int right = left + 1;
	    int res[] = new int[k];
	    for(int i = 0; i < k; i++) {
	      if (right >= array.length || left >= 0 && (Math.abs(array[left] - target) < Math.abs(array[right] - target))) {
	        res[i] = array[left--];
	      }  else {
	        res[i] = array[right++];
	      }
	    }
	    return res;
	  }
	  
	  
	  private int closest(int[] array, int target) {
	    int left = 0;
	    int right = array.length - 1;
	    while (left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (array[mid] == target) {
	        return mid;
	      } else if (array[mid] < target) {
	        left = mid;
	      } else {
	        right = mid;
	      }
	    }
	    return Math.abs(array[left] - target) <
	           Math.abs(array[right] - target) ?
	           left : right;
	  }
}
