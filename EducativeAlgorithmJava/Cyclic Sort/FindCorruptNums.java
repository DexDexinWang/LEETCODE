
public class FindCorruptNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public static int[] findNumbers(int[] nums) {
		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] != nums[nums[i] - 1]) {
		        swap(nums, i, nums[i] - 1);
		      } else {
		        i++;
		      }
		    }

		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] != i + 1) {
		    	  return new int[] { nums[i], i + 1 };
		      }
		    }
		    return new int[] { -1, -1 };
		  }

		  	private static void swap(int[] arr, int i, int j) {
			    int temp = arr[i];
			    arr[i] = arr[j];
			    arr[j] = temp;
			  }
	
}
