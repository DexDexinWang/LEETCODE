
public class CeilingOfANumber {
	public static int searchCeilingOfANumber(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] - 1 < key) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return arr[left] > key ? left : arr[right] > key ? right : -1;
	}

	public static void main(String[] args) {
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}
}
