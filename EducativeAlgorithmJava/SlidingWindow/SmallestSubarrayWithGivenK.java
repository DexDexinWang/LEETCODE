
public class SmallestSubarrayWithGivenK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findMinSubArray(int S, int[] arr) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		for(int i =0; i < arr.length; i++) {
			sum+= arr[i];
			while(sum >= S) {
				minLen = Math.min(minLen, right - left + 1);
				sum-=arr[left++];
			}
			right++;
		}
		return minLen == Integer.MAX_VALUE ? -1 : minLen;
	}
	
}
