import java.util.Arrays;

import integer.RandomIntegerArray;

public class ClassicalBinarySearch {
	public static void main(String[] args) 
	{
		int[] input = RandomIntegerArray.sortedArrayGen(10, 1, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(binarySearch(input, 5));
	}
	
	//Binary Search will define 2 pointers: left or right;
	//i means left, it indicated that all elements in left side of i are smaller than target (excluded i) 
	//j means right, it shows that all elements in right side of j are bigger than target (excluded j)
	//All elements between i and j will be checked. 
	public static int binarySearch(int[] array, int target) {
		//corner cases 
		if (array == null || array.length == 0) {
			return -1;
		}
		int i = 0;
		int j = array.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return -1;
	}
}
