class ArrayReader {
  int[] arr;

  ArrayReader(int[] arr) {
    this.arr = arr;
  }

  public int get(int index) {
    if (index >= arr.length)
      return Integer.MAX_VALUE;
    return arr[index];
  }
}

class SearchInfiniteSortedArray {

  public static int search(ArrayReader reader, int key) {
    int left = 0; 
    int right = 0;
    while(reader.get(right) !=  Integer.MAX_VALUE && reader.get(right) < key) {
      left = right;
      right = right * 2 + 1;
    }

    while(left <= right) {
      int mid = left + (right - left) / 2;
      int curr = reader.get(mid);
      if(curr == Integer.MAX_VALUE || curr > key) {
        right = mid - 1;
      } else if (curr < key) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
    System.out.println(SearchInfiniteSortedArray.search(reader, 16));
    System.out.println(SearchInfiniteSortedArray.search(reader, 11));
    reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
    System.out.println(SearchInfiniteSortedArray.search(reader, 15));
    System.out.println(SearchInfiniteSortedArray.search(reader, 200));
  }
}