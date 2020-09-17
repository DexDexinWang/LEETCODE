import java.util.Random;

public class Solution215 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {3,2,1,5,6,4};
		int[] input = {99,99};
		int k = 1;
		Solution215 test = new Solution215();
		System.out.println(test.findKthLargest(input, k));
	}
	
    int pivot; 
    public int findKthLargest(int[] nums, int k) {
    	k = nums.length - k ;
        int left = 0;
        int right = nums.length - 1;
        Integer res = 0;
        while(res != null) {
            if(res >= 0) {
                left = pivot;
            } else {
                right = pivot;
            }
            res = quickSort(nums, left, right, k);
        } 
        return nums[pivot];
    }

    private Integer quickSort(int[] arr, int left, int right, int k) {
        Random random = new Random();
        pivot = left + random.nextInt(right - left + 1);
        swap(arr, pivot, right);
        pivot = right; 
        while(left < pivot) {
            if(arr[left] >= arr[pivot]) {
                swap(arr, left, pivot);
                pivot --;
                swap(arr, left, pivot);
            } else {
            	left++;
            }
        }
        if(pivot == k) return null;
        else if(pivot < k) return ++pivot;
        else return -(--pivot);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


///stack of the recursion... worst case O(n) space
    public int quickSelect(int[] nums, int start, int end, int target) {
        
        int[] window = partition(nums, start, end);
        
        int left = window[0];
        int right = window[1];
        
        if (target <= right)
            return quickSelect(nums, start, right, target);
        else if (target >= left)
            return quickSelect(nums, left, end, target);
        else
            return nums[target];
    }

    private int[] partition(int[] nums, int left, int right) {
        
        int pivot = nums[left + (right - left) / 2];
        while (left <= right) {
            
            while (left <= right && nums[left] < pivot)
                left++;
        
            while (left <= right && nums[right] > pivot)
                right--;
            
            if (left <= right)
            {
                swap(nums, left, right);   
                left++;
                right--;
            }
        }
        
        return new int[] { left, right };
    }

    
}
