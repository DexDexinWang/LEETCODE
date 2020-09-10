class CyclicSort {

  public static void sort(int[] nums) {
    for(int i = 0; i < nums.length;) {
      if(nums[i]!= i + 1) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static void main(String[] args) {
	    int[] arr = new int[] { 3, 1, 5, 4, 2 };
	    CyclicSort.sort(arr);
	    for (int num : arr)
	      System.out.print(num + " ");
	    System.out.println();

	    arr = new int[] { 2, 6, 4, 3, 1, 5 };
	    CyclicSort.sort(arr);
	    for (int num : arr)
	      System.out.print(num + " ");
	    System.out.println();

	    arr = new int[] { 1, 5, 6, 4, 3, 2 };
	    CyclicSort.sort(arr);
	    for (int num : arr)
	      System.out.print(num + " ");
	    System.out.println();
	  }
}
