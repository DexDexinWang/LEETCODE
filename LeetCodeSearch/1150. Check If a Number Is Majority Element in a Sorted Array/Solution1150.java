
public class Solution1150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{2,4,5,5,5,5,5,6,6};
		System.out.println(findFirstOrLastOccurance(input, 5, true));
		System.out.println(findFirstOrLastOccurance(input, 5, false));
	}
	
    //For this problem we could directly check numbers of the elment in the mid of array.
    //Even elements: mid of {1,2,2} = 1;
    //Odd elements: mid of {1,2,2,2} = 1 or 2
    //Hence, we could check numbers of the first mid target.
    //Find the first occuancy.
    //Find the last occurancy. 
    //calculate pointers
    public static boolean isMajorityElement(int[] nums, int target) {
        int i = findFirstOrLastOccurance(nums, target, true);
        int j = findFirstOrLastOccurance(nums, target, false);
        return i == -1 || j == -1 ? false : (j - i + 1) > nums.length / 2; 
    }
    
    public static int findFirstOrLastOccurance(int[] nums, int target, boolean findFirst) {
        int i = 0; 
        int j = nums.length - 1;
        while (i < j - 1) {
            int mid = i + (j - i) / 2;
            if (findFirst) {
                if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            } else {
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid;
                }
            }
        }
        if (findFirst) {
            if (nums[i] == target) {
                return i;
            } else if (nums[j] == target) {
                return j;
            } else {
                return -1;
            }
        } else {
            if (nums[j] == target) {
                return j;
            } else if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
    }
}

