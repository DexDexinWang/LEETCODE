class MaxInBitonicArray {

	public static int findMax(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] <= arr[mid - 1]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return Math.max(arr[left], arr[right]);
	}

	public static void main(String[] args) {
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
	}
}