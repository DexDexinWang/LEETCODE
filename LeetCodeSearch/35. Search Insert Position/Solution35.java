
public class Solution35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j - 1) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid;
            } else {
                j = mid;
            }
        }
        if (target <= nums[i]) {
            return i;
        } else if (target <= nums[j]) {
            return j;
        } else {
            return j + 1;
        }
    }
}
