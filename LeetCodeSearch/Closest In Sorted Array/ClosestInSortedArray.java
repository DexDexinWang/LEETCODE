
public class ClosestInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Binary Search will define 2 pointers: left or right;
	//i means left, it indicated that all elements in left side of i are smaller than target (excluded i) 
	//j means right, it shows that all elements in right side of j are bigger than target (excluded j)
	//All elements between i and j will be checked. 
	public static int binarySearch(int[] array, int target) {	
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
	        j = mid; 
	      } else {
	        i = mid;
	      }
	    }
	    return Math.abs(array[i] - target) < Math.abs(array[j] - target) ? i : j ; 
	}
}
