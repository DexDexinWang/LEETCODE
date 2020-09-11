class SearchBitonicArray {

  public static int search(int[] arr, int key) {
    int mid = findMax(arr);
    if(arr[mid] == key) return mid;
    int leftPart = findTarget(arr, 0, mid - 1, key, true);
    return leftPart == -1? findTarget(arr, mid + 1, arr.length - 1, key, false) : leftPart;
  }

  public static int findTarget(int[] arr, int left, int right, int target, boolean isAccending) {
    while(left <= right) {
      int mid = left + (right - left) / 2;
      if(arr[mid] == target) {
        return mid;
      } else if(arr[mid] < target) {
        if(isAccending) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if(isAccending) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }

  public static int findMax(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while(left < right  -1) {
      int mid = left + (right - left)  / 2;
      if(arr[mid] > arr[mid - 1]) {
        left = mid;
      } else {
        right = mid - 1;
      }
      
    }
    return arr[left] > arr[right] ? left : right;
  }

  public static void main(String[] args) {
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
    System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
    System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
  }
}