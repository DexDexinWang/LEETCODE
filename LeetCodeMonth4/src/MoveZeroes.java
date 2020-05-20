
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//Solve the problem with 2 points: i and j start from the first element in the array.
    //All elements in the left side of i are not 0.
    //All elements between i and j are 0s.
    //All elements in the right side of j are unchecked elements.
	
	// 4 situations: 
	// i = 0 and j = 0 -> j++;
	// i != 0 and j = 0 -> j++;
	// i = 0 and j != 0 -> swap i and j; i++; j++;
	// i != 0 and j != 0 -> swap i and j; i++; j++;
	
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++]  = nums[j];
            }
            j++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
        return;
    }
    //Time complexity: O(n)
    //Space complexity: O(1)
}
