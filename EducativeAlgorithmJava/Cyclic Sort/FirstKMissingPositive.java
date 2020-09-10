import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

	public static void main(String[] args) {
		System.out.println(new FirstKMissingPositive().findNumbers(new int[] {2, 3, 4}, 3));

	}
	  public static List<Integer> findNumbers(int[] nums, int k) {
		    List<Integer> missingNumbers = new ArrayList<>();
		    for(int i = 0; i < nums.length;) {
		      if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
		        i++;
		      } else {
		        swap(nums, i, nums[i] - 1);
		      }
		    }
		    Set<Integer> extraNumbers = new HashSet<>();
		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] != i + 1) {
		    	extraNumbers.add(nums[i]);
		        missingNumbers.add(i + 1);
		        k--;
		        if(k == 0) {
		          return missingNumbers;
		        }
		      } 
		    }
		    int temp = nums.length + 1;
		    while(k != 0) {
		    	if(!extraNumbers.contains(temp)) { 
			    	missingNumbers.add(temp);
			    	k--;
		    	}
		    	temp++;
		    }
		    return missingNumbers;
		  }
	  private static void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
	  }
}
