
public class Solution260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for(int num : nums) {
            mask ^= num;
        }
        int mask1 = mask & (-mask);
        int x = 0;
        for(int num : nums) {
            if((mask1 & num)!=0) {
                x ^= num;
            }
        }
        return new int[]{x, mask ^ x};
    }
}
