
public class Solution136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }
}
