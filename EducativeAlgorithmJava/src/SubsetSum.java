
public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	  //DP[s] represent if there is a sum of combination will euqal the s.
	  //Base case DP[0] = true; 
	  //Induction Rule: if(s >=  num[i]) DP[s] = DP[s] || DP[s - num[i]], else DP[s] = DP[s];
	  public boolean canPartition(int[] num, int sum) {
	    int len = num.length;
	    boolean[] dp = new boolean[sum + 1];
	    dp[0] = true;
	    for(int i = 1; i < len; i++) {
	      dp[i] = num[0] == i;
	    }
	    for(int i = 1; i < len; i++) {
	      for(int s = sum; s >= 1; s--) {
	        if(s >= num[i]) {
	          dp[s] = dp[s] || dp[s - num[i]];
	        } 
	      }
	    }
	    return dp[sum];
	  }
}
