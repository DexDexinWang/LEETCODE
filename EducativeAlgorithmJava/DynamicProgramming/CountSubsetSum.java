
public class CountSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSubsetSum ss = new CountSubsetSum();
	    int[] num = { 1, 1, 2, 3 };
	    System.out.println(ss.countSubsets3(num, 4));
	    num = new int[] { 1, 2, 7, 1, 5 };
	    System.out.println(ss.countSubsets3(num, 9));
	}
	 
	//Bruteforce try all possible combinations
	//It will check n time
	//For each number, it will check whether the combination contains current number
	//Time complexity:O(2^n)
	//Spcae complexity:O(n) call stack
	public int countSubsets(int[] num, int sum) {
		return countSubsetsBst(num, 0, sum, 0);
	}
	
	private int countSubsetsBst(int[] num, int index, int target, int sum) {
		if(index == num.length) {
			return sum == target ? 1 : 0;
		}
		return countSubsetsBst(num, index + 1, target, sum + num[index]) + countSubsetsBst(num, index + 1, target, sum); 
	}
	
	//Bottom up DP 
	//Dp[i][s] represent from index 0 to index i, how many combinations equals to s 
	//DP[i][0] = 1;
	//DP[0][nums[0]] = 1;
	//DP[i][s] = if s-num[i]>=0 && dp[i-1][s - num[i]] != 0 ?  DP[i-1][s - num[i]] + DP[i - 1][s] : DP[i - 1][s];
	public int countSubsets2(int[] num, int sum) {
		int len = num.length;
		int[][] dp = new int[len][sum + 1];
		for(int i = 0; i < len; i++) dp[i][0] = 1;
		dp[0][num[0]] = 1;
		for(int i = 1; i < len; i++) {
			for(int s = 1; s <= sum; s++) {
				if(s-num[i]>=0 && dp[i-1][s-num[i]] != 0) {
					dp[i][s] = dp[i - 1][s - num[i]] + dp[i - 1][s];
				} else {
					dp[i][s] = dp[i - 1][s];
				}
			}
		}
		return dp[len - 1][sum];
	}
	
	//Bottom up DP 
	//Dp[s] represent from index 0 to index i, how many combinations equals to s 
	//DP[0] = 1;
	//DP[nums[0]] = 1;
	//DP[s] = if s-num[i]>=0 && dp[s - num[i]] != 0 ?  DP[s - num[i]] + DP[s] : DP[s];
	public int countSubsets3(int[] num, int sum) {
		int len = num.length;
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		dp[num[0]] = 1;
		for(int i = 1; i < len; i++) {
			for(int s = sum; s >= 0; s--) {
				if(s-num[i]>=0 && dp[s-num[i]] != 0) {
					dp[s] = dp[s - num[i]] + dp[s];
				} 
			}
		}
		return dp[sum];
	}
}
