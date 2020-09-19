
public class Solution1570 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class SparseVector {
	    int[] nums;
	    SparseVector(int[] nums) {
	        this.nums = nums;
	    }
	    
		// Return the dotProduct of two sparse vectors
	    public int dotProduct(SparseVector vec) {
	        int len = Math.min(nums.length, vec.nums.length);
	        int res = 0;
	        for(int i = 0; i < len; i++) {
	            res += vec.nums[i] * nums[i];
	        }
	        return res;
	    }
	}

}
