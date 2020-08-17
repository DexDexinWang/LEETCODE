
public class Solution746 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP[0] = cost[0]
    //DP[1] = cost[1]
    //DP[i] = Math.min(DP[i-1],DP[i-2]) + cost[i];
    //return Math.min(DP[n-1],DP[n-2])
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int min = Math.min(first,second) + cost[i];
            first = second;
            second = min;
        }
        return Math.min(first, second);
    }
}
