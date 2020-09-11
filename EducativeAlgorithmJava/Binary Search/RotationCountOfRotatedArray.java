class RotationCountOfRotatedArray {

  public static int countRotations(int[] arr) {
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
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
  }
}
