import java.util.Deque;
import java.util.LinkedList;

public class Solution5555 {

	public static void main(String[] args) {
		System.out.println( new Solution5555().countVowelStrings(1));

	}
    public int countVowelStrings(int n) {
        Deque<Integer> que = new LinkedList<>();
        que.offerLast(5);
        int sum = 5;
        while(n >= 2) {
            sum = 0;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int num = que.pollFirst();
                for(int j = num; j >= 1; j--) {
                    sum+=j;
                    que.offerLast(j);
                }
            }
            n--;
        }
        return sum;
    }
    
    public int countVowelStrings1(int n) {
    	int MOD = 1000_000_007;
        
        long[][] dp = new long[n + 1][5]; // dp[i][j] := a string of length 'i' ends with a vowel represented by index 'j'
        for(int i = 0; i < 5; i ++){
            dp[1][i] = 1; 
        }
    
        
		// State transition
        for(int i = 2; i <= n; i ++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] +  dp[i - 1][3]+ dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] +  dp[i - 1][3]+ dp[i - 1][4]) % MOD; 
            dp[i][2] = (dp[i - 1][2] + dp[i - 1][3]+ dp[i - 1][4]) % MOD; 
            dp[i][3] = (dp[i - 1][3] + dp[i - 1][4]) % MOD; 
            dp[i][4] = (dp[i - 1][4]) % MOD; 
        }
        
        long count = 0;
        
        for(long d : dp[n]){
            count += d;
            count %= MOD;
        }
 
        return (int) count;

    }
}
