
public class SmallestElementLargerThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public static int smallestElementLargerThanTarget(int[] array, int target) {
		    //The same problem as the closest elements in a sorted array. but it will focus on value > target
		    //corner case
		    if (array == null || array.length == 0) {
		      return -1;
		    }
		    int i = 0;
		    int j = array.length - 1; 
		    while (i < j) {
		      int mid = i + (j - i) / 2;
		      if (array[mid] <= target) {
		        i = mid + 1;
		      } else {
		        j = mid;
		      }
		    }
		    return array[i] > target ? i : -1;
		  }
}
