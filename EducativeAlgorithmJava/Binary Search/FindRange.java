class FindRange {

  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    int mostLeft = firstOccurence(arr, key);
    if(mostLeft != -1) {
      result[0] = mostLeft;
      result[1] = lastOccurence(arr, key);
    }
    return result;
  }

  public static int firstOccurence(int[] arr, int key) {
    int left = 0; 
    int right = arr.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if(arr[mid] >= key) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return arr[left] == key ? left : arr[right] == key ? right : -1;
  }

  public static int lastOccurence(int[] arr, int key) {
    int left = 0; 
    int right = arr.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if(arr[mid] <= key) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return arr[right] == key ? right : arr[left] == key ? left : -1;
  }

  public static void main(String[] args) {
    int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}