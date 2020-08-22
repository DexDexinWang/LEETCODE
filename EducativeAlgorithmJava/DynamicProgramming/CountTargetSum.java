
public class CountTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountTargetSum ts = new CountTargetSum();
	    int[] num = {1, 1, 2, 3};
	    System.out.println(ts.findTargetSubsets2(num, 1));
	    num = new int[]{1, 2, 7, 1};
	    System.out.println(ts.findTargetSubsets2(num, 9));
	}
	
	//Brute Find all combinations 
	//Time complexity O(2^n);
	//Space complexity O(n) call stacks
	public int findTargetSubsets(int[] num, int s) {
		return findTargetSubsetsBFS(num, 0, s, 0);
	}

	public int findTargetSubsetsBFS(int[] num, int index, int target, int sum) {
		if(index == num.length) return target == sum ? 1 : 0;
		return findTargetSubsetsBFS(num, index + 1, target, sum + num[index]) + findTargetSubsetsBFS(num, index + 1, target, sum-num[index]);
	}
	
	//Sum(s1) - Sum(s2) = target;
	//Sum(s1) + Sum(s2) = sum(all)
	//Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = target + sum(all);
	//2Sum(S1) = target + sum(all)
	//Sum(S1) = (target + Sum(all)) /2 
	//Find a combinations that equals (target+sum(all)) /2;
	//DP[i] represents how many combinations will be the sum;
	//DP[0] = 1;
	//DP[num[0]] = 1;
	//DP[i] = if(s - num[i]) ? DP[i] + DP[s - num[i]]: DP[i];  
	public int findTargetSubsets2(int[] num, int sum) {
		int len = num.length;
		int totalSum = 0;
		for(int i = 0; i < num.length; i++) {
			totalSum += num[i];
		}
		return countSubsets(num, (totalSum + sum)/2);
	}
	
	public int countSubsets(int[] num, int sum) {
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		dp[num[0]] = 1;
		for(int i = 1; i < num.length; i++) {
			for(int s = sum; s>=1; s--) {
				if(s >= num[i]) dp[s] += dp[s - num[i]];
			}
		}
		return dp[sum];
	}
}	
