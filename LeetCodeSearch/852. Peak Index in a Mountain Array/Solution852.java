
public class Solution852 {

	public static void main(String[] args) {
		System.out.print(peakIndexInMountainArray2(new int[] {3,4,5,1}));
	}
		
	public static int peakIndexInMountainArray(int[] A) {
        //assume that A.length >=3
		for(int i = 0; i < A.length; i++) {
			if (i == A.length - 1 || A[i] > A[i + 1]) {
				return i;
			}
		}
		return 0;
    }
	
	public static int peakIndexInMountainArray2(int[] A) {
        return help(A, 0, A.length - 1);
    }
	
	public static int help(int[] A, int i, int j) {
		if (j - i < 2) {
			return -1;
		} else {
			int mid = i + (j - i) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			} else if (A[mid] <= A[mid - 1] && A[mid] <= A[mid + 1]) {
				int tempA = help(A, mid, j);
				int tempB = help(A, i, mid);
				if (tempA == -1 && tempB == -1) {
					return -1;
				} else if (tempA != -1) {
					return tempA;
				} else {
					return tempB;
				}
			} else if (A[mid] <= A[mid -1]) {
				return help(A, i, mid);
			} else {
				return help(A, mid, j);
			}
		}
	}
	
}
