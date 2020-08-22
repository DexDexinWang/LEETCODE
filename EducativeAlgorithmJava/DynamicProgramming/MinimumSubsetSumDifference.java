
public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
	    int[] num = {1, 2, 3, 9};
	    System.out.println(ps.canPartition2(num));
	    num = new int[]{1, 2, 7, 1, 5};
	    System.out.println(ps.canPartition2(num));
	    num = new int[]{1, 3, 100, 4};
	    System.out.println(ps.canPartition2(num));
	}
	
	//BFS try all combinations for sum1 and sum2, return a reseult that has min(abs(sum1 - sum2));
	//Time complexity: O(2^n)
	//Space complexity: O(n) call stack 
	public int canPartition(int[] num) {
		 return this.canPartitionRecursive(num, 0, 0, 0);
	}
	
	private int canPartitionRecursive(int[] num, int index, int sum1, int sum2) {
		if(index == num.length) return Math.abs(sum1 - sum2);
		int temp1 = canPartitionRecursive(num, index + 1, sum1 + num[index], sum2);
		int temp2 = canPartitionRecursive(num, index + 1, sum1, sum2 + num[index]);
		return Math.min(temp1, temp2);
	}
	
	//Top Down DP + memorization
	//dp[i][s] represent the min differ when a sum of combination for(num[i] to num[n]);
	public int canPartition1(int[] num) {
		int sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		Integer[][] dp = new Integer[num.length][sum + 1];
		return canPartitionRecursive1(num, 0, 0, 0,dp);
	}
	
	private int canPartitionRecursive1(int[] num, int index, int sum1, int sum2 , Integer[][] dp) {
		if(index == num.length) return Math.abs(sum1 - sum2);
		if(dp[index][sum1] == null) { 
			int temp1 = canPartitionRecursive1(num, index + 1, sum1 + num[index], sum2, dp);
			int temp2 = canPartitionRecursive1(num, index + 1, sum1, sum2 + num[index], dp);
			dp[index][sum1] = Math.min(temp1,  temp2);
		}
		return dp[index][sum1];
	}
	
	//Bottom up DP + memorization
	//dp[i][s] represent the combination of num[0] to num[i] == s; 
	//Base case dp[0][0] = true;
	//dp[0][num[0]] = rue;
	//DP[i][s] = s - num[i] >= 0  ? dp[i - 1][s] || dp[i - 1][s - nums[i]] : dp[i - 1][s]
	//Time complexity: O(n*s)  where s = s/2;
	//Sapce complexity:O(n*s)
	public int canPartition2(int[] num) {
		int sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		int totalSum = sum;
		sum = sum / 2;
		boolean[][] dp = new boolean[num.length][sum + 1];
		for(int i = 0 ; i < num.length; i++) dp[i][0] = true;
		dp[0][num[0]] = true;
		for(int i = 1; i < num.length; i++) {
			for(int s = 1; s <= sum; s++) {
				dp[i][s] = s - num[i]>= 0 ? dp[i-1][s] || dp[i - 1][s - num[i]] : dp[i - 1][s]; 
			}
		}
		int sum1 = 0;
		for(int i = sum; i >= 0 ;i--) {
			if(dp[num.length - 1][i]) {
				sum1 = i;
				break;
			}
		}
		return Math.abs(sum1-(totalSum - sum1));
	}
	
	//Bottom up DP + memorization
	//dp[s] represent the combination of num[0] to num[i] == s; 
	//Base case dp[0] = true;
	//dp[num[0]] = rue;
	//DP[s] = s - num[i] >= 0  ? dp[s] || dp[s - nums[i]] : dp[s]
	//Time complexity: O(n*s)  where s = s/2;
	//Sapce complexity:O(s)
	public int canPartition3(int[] num) {
		int sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		int totalSum = sum;
		sum = sum / 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		dp[num[0]] = true;
		for(int i = 1; i < num.length; i++) {
			for(int s = sum; s >= 1; s--) {
				dp[s] = s - num[i]>= 0 ? dp[s] || dp[s - num[i]] : dp[s]; 
			}
		}
		int sum1 = 0;
		for(int i = sum; i >= 0 ;i--) {
			if(dp[i]) {
				sum1 = i;
				break;
			}
		}
		return Math.abs(sum1-(totalSum - sum1));
	}
}
