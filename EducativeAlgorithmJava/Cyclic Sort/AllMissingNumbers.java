import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
	  public static List<Integer> findNumbers(int[] nums) {
		    List<Integer> missingNumbers = new ArrayList<>();

		    for(int i = 0; i < nums.length;) {
		      if(nums[i] == i + 1 || nums[nums[i]-1] == nums[i]) {
		        i++;
		      } else {
		        swap(nums, i, nums[i] - 1);
		      }
		    }// TODO: Write your code here

		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] != i + 1) {
		        missingNumbers.add(i + 1);
		      }
		    }
		    return missingNumbers;
		  }
	  public static void swap(int[] arr, int i, int j) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		  }
}
