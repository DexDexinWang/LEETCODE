import java.util.Arrays;
import java.util.Collections;

public class MinStepstoMakePilesEqualHeight {

	/**
Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the maximum height 
and try to make it equal to the one which is just lower than the maximum height of the stack. 
Determine the minimum number of steps required to make all of the piles equal in height.

Example 1:

Input: piles = [5, 2, 1]
Output: 3
Explanation:
Step 1: reducing 5 -> 2 [2, 2, 1]
Step 2: reducing 2 -> 1 [2, 1, 1]
Step 3: reducing 2 -> 1 [1, 1, 1]
So final number of steps required is 3.
	 * @param args
	 */
	
	/**
	 * The problem could be solved by counting sort issue
	 * 
	 * Time complexity O(n + nlogn)  space complexity O(n) 
	 * @return
	 */
	public int MinStepstoMakePilesEqualHeight(int[] piles) {
		//int[] sortedPiles = Arrays.stream(piles).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		Arrays.sort(piles);
		int sum = 0;
		for(int i = 0; i < piles.length - 1; i++) {
			if(piles[i] != piles[i + 1]) {
				sum += i+1;
			}
		}
		return sum;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStepstoMakePilesEqualHeight solution = new MinStepstoMakePilesEqualHeight();
		int sum = solution.MinStepstoMakePilesEqualHeight(new int[] {1, 1, 2, 2, 2, 3, 3, 3, 4, 4});
		System.out.println(sum);
	}

}
