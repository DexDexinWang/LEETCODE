import java.util.Arrays;

public class Solution268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution268().missingNumber(new int[] {0,1,2,3}));
	}
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).reduce(0, (a,b)->(a+b));
        int total = (nums.length + 1) * (nums.length) / 2;
        return total - sum;
    }
}
