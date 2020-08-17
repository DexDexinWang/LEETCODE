
public class Solution53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <1) {
            return 0;
        } 
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i-1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length <1) {
            return 0;
        } else {
            return devideAndConquer(nums, 0, nums.length - 1);
        }
    }
    
    public int devideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSubSum = devideAndConquer(nums, left, mid);
        int rightSubSum = devideAndConquer(nums, mid +1, right);
        int crossSum = getCrossSum(nums, left, right, mid);
        
        return Math.max(Math.max(leftSubSum, rightSubSum), crossSum);
    }
    
    public int getCrossSum(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = mid; i > left - 1; i--) {
            currSum += nums[i];
            leftSubSum = Math.max(currSum, leftSubSum);
        }
        
        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0; 
        for (int i = mid + 1; i < right + 1; i++) {
            currSum += nums[i];
            rightSubSum = Math.max(currSum, rightSubSum);
        }
        return leftSubSum +  rightSubSum;
    }
}
