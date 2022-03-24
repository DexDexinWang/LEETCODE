
public class Solution6015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution6015 s = new Solution6015();
		System.out.print(s.coutPairs(new int[] {1,2,3,4,5}, 2));
	}

    public long coutPairs(int[] nums, int k) {
        if(nums.length == 1) {
            return 0;
        }
        int size = nums.length;
        int sum = 0;
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
            	if((nums[i] + nums[j]) % k == 0) {
            		sum++;
            	}
            }
        }
        return sum;
    }
}
