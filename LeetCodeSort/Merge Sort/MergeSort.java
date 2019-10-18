import java.util.Arrays;

import integer.RandomIntegerArray;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = RandomIntegerArray.arrayGen(5);
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] array) {
		
	}
}
