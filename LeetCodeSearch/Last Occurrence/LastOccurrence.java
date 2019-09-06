
public class LastOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int lastOccur(int[] array, int target) {
		 if (array == null || array.length == 0) {
			 return -1;
		 }
		 int i = 0;
		 int j = array.length - 1;
		 while (i < j - 1) {
			 int mid = i +  (j - i) / 2;
			 if (array[mid] > target) {
				 j = mid - 1;
			 } else {
				 i = mid;
			 }
		 }
		 if (array[j] == target) {
			 return j;
		 } else if (array[i] == target) {
			 return i;
		 }
		 return -1;
	 }
}
