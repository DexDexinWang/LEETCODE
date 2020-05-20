
public class SingleNumber {

	/*
	 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

	Note:
	
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
	Example 1:
	
	Input: [2,2,1]
	Output: 1
	Example 2:
	
	Input: [4,1,2,1,2]
	Output: 4

	 * */
	public static void main(String[] args) {
		int[] nums = new int[] {2,2,1};
		System.out.print(singleNumber(nums));
	}
	//BIT XOR. 
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;  
        }
        return res;
    }
    //Time complexity is O(n);
    //Space complexity is O(1);
}
