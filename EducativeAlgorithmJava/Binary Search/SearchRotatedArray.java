class SearchRotatedArray {

  public static int search(int[] arr, int key) {
    int start = findStart(arr);
    int len = arr.length;
    int left = 0;
    int right = 0;
    if(key > arr[len - 1]) {
      left = 0;
      right = start - 1;
    } else {
      left = start;
      right = len - 1;
    }
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      } else if (arr[mid] < key) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int findStart(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while(left < right - 1) {
      int mid =  left + (right - left) / 2;
      if(arr[mid] < arr[mid -1]) {
        return mid;
      }else {
        if(arr[mid] < arr[right]) {
          right = mid;
        } else {
          left = mid;
        }
      }
    }
    return arr[left] <= arr[right] ? left : right;
  }

  public static void main(String[] args) {
    System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
    System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
  }
}
