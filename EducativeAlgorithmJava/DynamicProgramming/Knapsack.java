
public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack ks = new Knapsack();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int maxProfit = ks.solveKnapsack3(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsack3(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	}
	
	//BFS
    //How many leves for the tree:  product length;
    //How many status for each level: 2 status --> pack it or not
	//Time complexity: O(2^n) 
	//Space complexity: O(n) call stack
    private int solveKnapsack(int[] profits, int[] weights, int capacity) 
    {
       return bfs(0, profits, weights, capacity);
    }

    private int bfs(int index, int[] profits, int[]weights, int capacity){
        if(capacity <= 0 || index >= profits.length) return 0;
        int profit1 = bfs(index + 1, profits, weights, capacity);
        int profit2 = 0;
        if(weights[index] <= capacity) {
            profit2 = profits[index] + bfs(index + 1, profits, weights, capacity - weights[index]);
        }
        return Math.max(profit1, profit2);
    }
    

    //Top Down DP + Memoization 
    //DP[x][y] record the maximum profit if there is only "y" capacity if there are some products from x to n including x. weights[x] to weights[n]
    //Time complexity: O(n * c) where n is the length of profits, and c is the capacity size. becuase there is no more than n*c situations.
    //Space complexity: O(n * c)
    private int solveKnapsack1(int[] profits, int[] weights, int capacity) 
    {
    	Integer[][] memo = new Integer[profits.length][capacity + 1];
        return bfs(0, profits, weights, capacity, memo);
    }
    
    private int bfs(int index, int[] profits, int[]weights, int capacity, Integer[][] memo){
        if(capacity <= 0 || index >= profits.length) return 0;
        if(memo[index][capacity] != null) return memo[index][capacity];
        int profit1 = bfs(index + 1, profits, weights, capacity);
        int profit2 = 0;
        if(weights[index] <= capacity) {
            profit2 = profits[index] + bfs(index + 1, profits, weights, capacity - weights[index]);
        }
        memo[index][capacity] = Math.max(profit1, profit2);
        return memo[index][capacity];
    }
    
    //Bottom up DP + Memorization
    //DP[0][0] = 0 
    //DP[0][c] = profits[0] if weights[0] >= c 
    //DP[i][c] = Math.max(DP[i - 1][c], profit[i] + DP[i - 1][c-weight[i]])
    //Time complexity: O(n*c)
    //Space complexity: O(n*c)
    private int solveKnapsack2(int[] profits, int[] weights, int capacity) 
    {
    	
    	int[][] dp = new int[profits.length][capacity + 1];
    	for(int c = 1 ; c <=capacity; c++) {
    		dp[0][c] = weights[0] >= c ? profits[0] : 0; 
    	}
    	for(int i = 1; i < weights.length; i ++) {
    		for(int c = 1; c <= capacity; c++) {
    			dp[i][c] = dp[i-1][c];
    			if(c-weights[i]>= 0) {
    				dp[i][c] = Math.max(dp[i][c], profits[i] + dp[i-1][c-weights[i]]);
    			}
    		}
    	}
        return dp[profits.length - 1][capacity];
    }
    
    //Bottom up DP + Memorization + Space optimization
    //DP[0] = 0 
    //DP[c] = profits[0] if weights[0] >= c 
    //DP[c] = Math.max(DP[c], profit[i] + DP[c-weight[i]]);
    //Time complexity: O(n*c)
    //Space complexity: O(n)
    private int solveKnapsack3(int[] profits, int[] weights, int capacity) 
    {
    	
    	int[] dp = new int[capacity + 1];
    	for(int c = 1 ; c <=capacity; c++) {
    		dp[c] = weights[0] >= c ? profits[0] : 0; 
    	}
    	for(int i = 1; i < weights.length; i ++) {
    		//Reverse that will not affect the previous result.
    		for(int c = capacity; c >= 0; c--) {
    			int profit1 = dp[c];
    			int profit2 = 0;
    			if(c-weights[i]>= 0) {
    				profit2 = profits[i] + dp[c-weights[i]];
    			}
    			dp[c] = Math.max(profit1, profit2);
    		}
    	}
        return dp[capacity];
    }
}
