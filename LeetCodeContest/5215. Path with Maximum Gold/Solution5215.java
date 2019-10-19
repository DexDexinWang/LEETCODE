
/**
 * 5214. Longest Arithmetic Subsequence of Given Difference
User Accepted:1896
User Tried:3079
Total Accepted:1945
Total Submissions:7415
Difficulty:Medium
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].
 

Constraints:

1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
 * @author Cindy
 *
 */
public class Solution5215 {

	public static void main(String[] args) {
		Solution5215 test = new Solution5215();
		int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
		System.out.println(test.getMaximumGold(grid));
	}

	
	public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[grid.length][grid[i].length];
                    int tempRes = returnMax(grid, i, j, 0, visited);
                    if (max < tempRes) {
                        max = tempRes;
                    }
                }
            }
        }
        return max;
    }
    
	private int returnMax(int[][] grid, int x, int y, int sum, boolean[][] visited) {
        visited[x][y] = true;
        //going up
        int up = sum + grid[x][y];
        int down = sum + grid[x][y];
        int left = sum + grid[x][y];
        int right = sum + grid[x][y];
        if (x - 1 >= 0 && visited[x - 1][y] == false && grid[x - 1][y] != 0) {
             up = returnMax(grid, x - 1, y, up, visited);
        }
        if (x + 1 <= grid.length -1 && visited[x + 1][y] == false &&  grid[x + 1][y] != 0) {
            down = returnMax(grid, x + 1, y, down, visited);
        }
        if (y - 1 >= 0 && visited[x][y - 1] == false && grid[x][y-1] != 0) {
            left = returnMax(grid, x, y - 1, left, visited);
        }
        if (y + 1 <= grid[x].length - 1 && visited[x][y + 1] == false && grid[x][y+1] != 0) {
            right = returnMax(grid, x, y + 1, right, visited);
        }
        int max = Math.max(Math.max(up, down),Math.max(left,right));
        visited[x][y] = false;
        return max;
    }
	
}
