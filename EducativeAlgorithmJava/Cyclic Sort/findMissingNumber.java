class MissingNumber {

  public static int findMissingNumber(int[] nums) {
    for(int i = 0; i < nums.length;) {
      if(nums[i] == i || nums[i] >= nums.length) {
        i++;
      } else {
        swap(nums, i, nums[i]);
      }
    }
    
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != i) {
        return i;
      }
    }
    return nums.length;
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static void main(String[] args) {
	    System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
	    System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	  }
}
