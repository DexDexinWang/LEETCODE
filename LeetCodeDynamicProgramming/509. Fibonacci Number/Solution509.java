
public class Solution509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //base case: dp[0] = 0; dp[1] = 1;
    //induction rule: dp[i] = dp[i - 1] + dp[i - 2];
    public int fib(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } 
        int a = 0;
        int b = 1;
        int res = 0;
        for(int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
