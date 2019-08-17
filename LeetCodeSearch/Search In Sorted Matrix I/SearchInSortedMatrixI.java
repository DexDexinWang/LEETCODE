import java.util.Arrays;

import integer.RandomIntegerArray;

public class SearchInSortedMatrixI {

	public static void main(String[] args) {
		int[][] input = RandomIntegerArray.twoDNoDuplicatedArrayGen(16, 1, 100);
		System.out.println(Arrays.deepToString(input));
		System.out.println(search(input, 5));
	}
	
	public static int[] search(int[][] matrix, int target) {
		//It`s a converted question of binary search
	    //Assume 2D matrix is 1D array with 2 pointers: i and j
	    //all elements in left side of i are smaller than target
	    //all elements in right side of j are bigger than target
	    //corner cases
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	      return new int[]{-1,-1};
	    } // also it should check each 
	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    int i = 0; 
	    int j = rows * cols -1;

	    while (i <= j) {
	      int mid = i + (j - i) / 2;
	      int x = mid / cols;
	      int y = mid % cols; 
	      if (matrix[x][y] == target) {
	        return new int[]{x,y};
	      } else if (matrix[x][y] > target) {
	        j = mid - 1; 
	      } else {
	        i = mid + 1;
	      }
	    }
	    return new int[]{-1,-1};
	  }
	//Time complexity: O(logn)
	//Space complextiy: O(1);
}
