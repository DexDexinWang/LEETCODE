
public class Solution303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class NumArray {
	    int[] preSum;
	    public NumArray(int[] nums) {
	        preSum = new int[nums.length + 1];
	        for(int i = 0; i < nums.length; i++) {
	            preSum[1+i]=preSum[i] + nums[i];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	        return preSum[j + 1]-preSum[i];
	    }
	}
}
