
public class Solution1277 {

	public static void main(String[] args) {
		
	}
    //DP solution
    //DP[0][0] = 1 where matrix[0][0] = 1 
    //DP[i][j] = min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j]) + 1 where matrix[i][j] == 1 and  (count += dp[i][j]); otherwise 0;
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if(matrix[i][j] == 1) {
                        int min = Math.min(dp[i][j - 1],Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                        dp[i][j] = min + 1;
                    } 
                } 
                count+= dp[i][j];
            }
        }
        return count;
    }
}
