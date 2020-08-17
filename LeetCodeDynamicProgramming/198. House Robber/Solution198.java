
public class Solution198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP represent the maximum value 
    //DP[0] = 0
    //DP[1] = 0
    //DP[2] = Math.max(DP[0] + num[0], DP[1]);
    //DP[i] = Math.max(DP[i-2] + num[i-2], DP[i-1]);
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for(int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
