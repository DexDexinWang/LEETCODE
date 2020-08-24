
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findTarget(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			if(arr[left] + arr[right] == target) {
				return new int[] {left, right};
			} else if (arr[left] + arr[right] < target) {
				left++;
			} else {
				right++;
			}
		}
		return new int[] {-1,-1};
	}
}
