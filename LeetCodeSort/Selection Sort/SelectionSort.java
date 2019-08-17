import java.util.Arrays;

import integer.RandomIntegerArray;
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = RandomIntegerArray.arrayGen(5);
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static int[] selectionSort(int[] array) {
		//corner cases
		if (array == null) {
			return array;
		}
		int size = array.length;
		if (size == 1) {
			return array;
		}
		for (int i = 0; i < size - 1; i++) {
			int min = array[i];
			int minPosition = i;
			for (int j = i; j < size; j++) {
				if (array[j] < min) {
					min = array[j];
					minPosition = j;
				}
			}
			swap(array, i , minPosition);
		}
		return array;
		
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//Time complexity O(n) * O(n*(n-1)/2) = O(n^2);
	//Space complexity O(1) 
}

