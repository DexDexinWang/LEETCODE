
public class MaximumSubarray {

	/**
	 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

		Example:
		
		Input: [-2,1,-3,4,-1,2,1,-5,4],
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
		Follow up:
		
		If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DP
	//Base case: maxSubSum = nums[0];
	//principle Rule: maxSubSum = Max(sum(nums[j] to nums[i]), nums[i]);    
	public static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = nums[0];
		for(int i = 1 ; i < nums.length - 1; i ++) {
			if (nums[i - 1] > 0) nums[i] += nums[i - 1];
			sum = Math.max(sum, nums[i]);
		}
		return sum;
	}

	
	//For this problem, it considers that whether contiguous could be empty or not. 
	//Divide and Conquer
    public static int maxSubArray(int[] nums) {
    	//corner case, empty or length is smaller than 1
        if (nums== null || nums.length < 1) {
        	return 0;
        } else {
        	return divideAndConquer(nums, 0, nums.length - 1);
        }
    }
    //Time complexity O(nlogn)
    //Space complexity O(logn)
    
    public static int divideAndConquer(int[] nums, int left, int right) {
    	if (left == right) {
    		return nums[left];
    	}
    	
    	int mid = (left + right) / 2;
    	int leftSum = divideAndConquer(nums, left, mid); // get max sub array form the left side
    	int rightSum = divideAndConquer(nums, mid + 1, right); // get max sub array from the right side
    	int crossSum = getCrossSum(nums, left, right, mid); // get max sub array from current array from left to right.
    	
    	return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    public static int getCrossSum(int[] nums, int left,int right,int mid) {
    	//if there is only one element, just return it. 
    	if (left == right) return nums[left];
    	
    	int leftSubSum = Integer.MIN_VALUE;
    	int currSum = 0;
    	for(int i = mid; i > left - 1; i--) {
    		currSum += nums[i];
    		leftSubSum = Math.max(leftSubSum, currSum);
    	}
    	
    	int rightSubSum = Integer.MIN_VALUE;
    	currSum = 0;
    	for(int i = mid + 1; i < right + 1;  i++) {
    		currSum += nums[i];
    		rightSubSum = Math.max(rightSubSum, currSum);
    	}
    	
    	return leftSubSum + rightSubSum;
    }
    
}
