
public class Solution169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution169().majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        int size = nums.length;
        for(int i = 1; i < size; i++) {
            if(nums[i] != res) {
                count--;
                if(count == 0) {
                    res = nums[i + 1];
                    count = 1;
                    i++;
                }
            } else {
                count++;
            }
        }
        return res;
    }
    
    public int majorityElement1(int[] nums) {
        int res = 0;
        int size = nums.length;
        for(int i = 0; i < 32; i++) {
            int ones = 0;
            for(int j = 0; j < size; j++) {
                if((nums[j] & (1 << i)) != 0) {
                    ones++;
                }
            }
            if(ones > size - ones) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}
