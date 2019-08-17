
public class ClosestInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int binarySearch(int[] array, int target) {
	    //It`s another converted binary search question. It could be solved with 2 pointers: i and j
	    //All elements in left side of i are smaller than target
	    //ALl elements in right side of j are bigger than target
	    //corner cases
	    if (array == null || array.length == 0) {
	      return -1;
	    }
	    int i = 0; 
	    int j = array.length - 1;
	    while (i < j - 1) {
	      int mid = i + (j - i) / 2;
	      if (array[mid] == target) {
	        return mid;
	      } else if (array[mid] > target) {
	        j = mid; // it should keep the value, the mid value may be the closet value.
	      } else {
	        i = mid;
	      }
	    }
	    return Math.abs(array[i] - target) < Math.abs(array[j] - target) ? i : j ; 
	}
}
