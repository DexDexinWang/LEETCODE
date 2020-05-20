
public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Bruteforce, Time(n^3) trverse each sub-rectanges, space complexity O(1)
    //DP problem, 
    //Base case: int[0][0] = matrix[0][0]
    //Induction rule: int[i][j] = min(int[i-1][j-1], int[i][j-1], int[i-1][j]) + 1 if matrix[i][j] = 1 otherwise 0;
    public int maximalSquare(char[][] matrix) {
        //corner cases
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                    globalMax = Math.max(globalMax, dp[i][j]);
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        int currentMax = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        dp[i][j] = currentMax;
                        globalMax = Math.max(currentMax, globalMax);
                    }
                }
            }
        }
        return globalMax*globalMax;
    }
}
