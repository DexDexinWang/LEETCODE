
public class EqualSubsetSumPartition {

	public static void main(String[] args) {
		
		EqualSubsetSumPartition test = new EqualSubsetSumPartition();
		System.out.println(test.canPartition3(new int[] {1,2,3,4}));
		System.out.println(test.canPartition3(new int[] {1,1,3,4,7}));
		System.out.println(test.canPartition3(new int[] {2,3,4,6}));
	}
	
	//Brute force try all possible combinations
	//Time complexity O(2^n);
	//Space complexity O(n);
	public boolean canPartition(int[] num) {
		return bfs(num, 0, 0, 0);
	}
	
	public boolean bfs(int[] num, int index, int sum1, int sum2) {
		if(index == num.length - 1) return sum1 + num[index] == sum2 || sum1 == sum2  + num[index]; 
		return bfs(num, index + 1, sum1 + num[index],sum2) || bfs(num, index + 1, sum1,sum2 + num[index]); 
	}
	
	//Top Down DP + Memorization
	//DP[i][s] saves whether in the index i position with s sum can be partitioned.
	//Time complexity: O(n * s);
	//Space complexity: O(n * s) 
	public boolean canPartition1(int[] num) {
		int sum = 0;
		for(int i =0; i < num.length; i++) {
			sum += num[i];
		}
		if(sum % 2 != 0) return false;
		Boolean[][] dp = new Boolean[num.length][sum/2 + 1];
		return canPartitionHelp1(num, 0, sum, dp);
	}
	
	private boolean canPartitionHelp1(int[] num, int index, int sum, Boolean[][] dp) {
		if (sum == 0) return true;
		if(index >= num.length) return false;
		if(dp[index][sum] != null) return true;
		boolean res1 = false;
		if(sum - num[index] >= 0) {
			res1 = canPartitionHelp1(num, index + 1, sum - num[index], dp);
		}
		boolean res2 = canPartitionHelp1(num, index + 1, sum, dp);
		dp[index][sum] = res1 || res2;
		return dp[index][sum];
	} 
	
	//Bottom Up DP + Memorization
	public boolean canPartition2(int[] num) {
		int sum = 0;
		for(int i =0; i < num.length; i++) {
			sum += num[i];
		}
		if(sum % 2 != 0) return false;
		sum = sum / 2;
		boolean[][] dp = new boolean[num.length][sum + 1];
		for(int i = 0; i < num.length; i++ ){
			dp[i][0] = true;
		}
		//consider there is only one number 
		for(int i = 1 ; i <= sum; i++) {
			dp[0][i] = (num[0] == i) ? true : false;
		}
		for(int i = 1; i < num.length; i++) {
			for(int s = 1; s <= sum; s++) {
				if(dp[i -1][s]) {
					dp[i][s] = true;
				} else if (s >= num[i]) {
					dp[i][s] = dp[i - 1][s - num[i]];
				}
			}
		}
		return dp[num.length - 1][sum];
	}
	
	//Bottom Up DP + Memorization Optimization 
	public boolean canPartition3(int[] num) {
		int sum = 0;
		for(int i =0; i < num.length; i++) {
			sum += num[i];
		}
		if(sum % 2 != 0) return false;
		sum = sum / 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		//consider there is only one number 
		for(int i = 1 ; i <= sum; i++) {
			dp[i] = (num[0] == i) ? true : false;
		}
		for(int i = 1; i < num.length; i++) {
			for(int s = sum; s >= 1; s--) {
				if (s >= num[i]) {
					dp[s] = dp[s - num[i]];
				}
			}
		}
		return dp[sum];
	} 
}
