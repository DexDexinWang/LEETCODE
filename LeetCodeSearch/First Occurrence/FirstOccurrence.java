
public class FirstOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		  public int firstOccur(int[] array, int target) {
			    //Could be solved like solving binary search with 2 pointers. i and j;
			    //corner cases
			    if (array == null || array.length == 0) {
			      return -1;
			    }
			    int i = 0;
			    int j = array.length - 1;
			    while (i < j - 1) {
			      int mid = i + (j - i) / 2;
			      if (array[mid] < target) {
			        i = mid + 1;
			      } else {
			        j = mid;
			      }
			    }
			    if(array[i] != target && array[j] != target) {
			      return -1;
			    } else {
			      return array[i] == target ? i : j;
			    }
			  }
}
