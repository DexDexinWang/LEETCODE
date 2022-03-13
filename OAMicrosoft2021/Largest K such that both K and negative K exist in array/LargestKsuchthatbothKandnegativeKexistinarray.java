import java.util.HashSet;
import java.util.Set;

public class LargestKsuchthatbothKandnegativeKexistinarray {

	/**
	 * 
Write a function that, given an array A of N integers, 
returns the lagest integer K > 0 such that both values 
K and -K exist in array A. If there is no such integer, 
the function should return 0.

Example 1:

Input: [3, 2, -2, 5, -3]
Output: 3
Example 2:

Input: [1, 2, 3, -4]
Output: 0
	 * @param args
	 */
	
	/**
	 * Use a queue to 
	 * @param args
	 */
	
	public int LargestKsuchthatbothKandnegativeKexistinarray(int[] array) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for(int num: array) {
			if(set.contains(num)) {
				max = Math.max(max, Math.abs(num));
			} else {
				set.add(-num);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LargestKsuchthatbothKandnegativeKexistinarray solution = new LargestKsuchthatbothKandnegativeKexistinarray();
		int res = solution.LargestKsuchthatbothKandnegativeKexistinarray(new int[] {3, 2, -2, 5, -3});
		System.out.print(res);

	}

}
