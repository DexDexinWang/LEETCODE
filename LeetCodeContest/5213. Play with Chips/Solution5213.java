
/**
 * 5213. Play with Chips
User Accepted:2811
User Tried:3312
Total Accepted:2861
Total Submissions:5095
Difficulty:Easy
There are some chips, and the i-th chip is at position chips[i].

You can perform any of the two following types of moves any number of times (possibly zero) on any chip:

Move the i-th chip by 2 units to the left or to the right with a cost of 0.
Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
There can be two or more chips at the same position initially.

Return the minimum cost needed to move all the chips to the same position (any position).
 * @author Cindy
 *
 */
public class Solution5213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public int minCostToMoveChips(int[] chips) {
	        int odd = 0;
	        int even = 0;
	        for(Integer num: chips) {
	            if (num % 2 == 1) {
	                odd++;
	            } else {
	                even++;
	            }
	        }
	        return Math.min(odd,even);
	    }
	}
}
