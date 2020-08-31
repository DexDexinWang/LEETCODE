
public class ShiftedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ShiftedArraySearch().shiftedArrSearch2(new int[]{0,1,2,3,4,5,6}, 4));
	}
	
	public  int shiftedArrSearch(int[] arr, int num) {
		int pivot = findPivot(arr);
		int left;
		int right;
		if(arr[arr.length - 1] >= num) {
			left =pivot;
			right = arr.length - 1;
		} else {
			left = 0;
			right = pivot - 1;
		}
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == num) {
				return mid;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public int findPivot(int[] arr) {
		if (arr == null || arr.length <=1) return 0;
		int left = 0;
		int right = arr.length -1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(mid == 0 || arr[mid - 1] > arr[mid]) {
				return mid;
			} else if (arr[mid] < arr[0]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}
	
	public  int shiftedArrSearch2(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == num) {
				return mid;
			} else if (arr[left] < arr[mid]) {
				if (arr[left] <= num && arr[mid] >= num) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if(arr[mid] <= num && arr[right] >= num) {
					left = mid +1;
				} else {
					right = mid -1;
				}
			}
		}
		return -1;
	}
	
}
