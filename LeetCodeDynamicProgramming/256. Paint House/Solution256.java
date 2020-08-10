
public class Solution256 {

	public static void main(String[] args) {
		
	}

    //Base Case
    //DP[n][0] = DP[n][0]
    //DP[n][1] = DP[n][1]
    //DP[n][2] = DP[n][2]
    //Induction Rule: 
    //DP[n-1][0] += min(DP[n][1],DP[n][2])
    //DP[n-1][1] += min(DP[n][0],DP[n][2])
    //DP[n-1][2] += min(DP[n][0],DP[n][1])
    public int minCost(int[][] costs) {
        for(int i = costs.length - 1; i>=1; i--) {
            costs[i-1][0] += Math.min(costs[i][1],costs[i][2]);
            costs[i-1][1] += Math.min(costs[i][0],costs[i][2]);
            costs[i-1][2] += Math.min(costs[i][0],costs[i][1]);
        }
        if(costs.length == 0) return 0;
        return Math.min(Math.min(costs[0][2],costs[0][1]),costs[0][0]);
    }
}
