
public class RemoveDulicated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static int removeDuplicated(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		if(arr.length == 1 ) return 1;
		int i = 0;
		int j = 0;
		int count = 1;
		while(j < arr.length) {
			if(j > 0 && arr[j-1] != arr[j]) {
				j++;
			} else {
				arr[i++] = arr[j++];
				count++;
			}
		}
		return count;
	  }
}
