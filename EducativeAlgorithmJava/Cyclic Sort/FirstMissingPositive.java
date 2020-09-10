
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FirstMissingPositive().findNumber(new int[] {-3, 1, 5, 4, 2}));
	}
	  public static int findNumber(int[] nums) {
		    for(int i = 0; i < nums.length;) {
		      if(nums[i] == i+ 1 || nums[i] <= 0 || nums[i] > nums.length) {
		        i++;
		      } else {
		        swap(nums, i, nums[i] - 1);
		      }
		    }
		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] != i + 1) return i+1;
		    }
		    return -1;
		  }
		  private static void swap(int[] arr, int i, int j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
		  }
}
