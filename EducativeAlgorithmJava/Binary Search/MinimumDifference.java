class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    int left = 0;
    int right = arr.length - 1;
    while(left < right - 1) {
      int mid = left + (right - left) / 2;
      if(arr[mid] == key) {
        return arr[mid];
      } else if (arr[mid] > key) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return Math.abs(arr[left] - key) < Math.abs(arr[right] - key) ? arr[left] : arr[right];
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}