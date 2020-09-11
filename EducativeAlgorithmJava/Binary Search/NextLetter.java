
public class NextLetter {

	/*
	 * Problem Statement # Given an array of lowercase letters sorted in ascending
	 * order, find the smallest letter in the given array greater than a given
	 * ¡®key¡¯.
	 * 
	 * Assume the given array is a circular list, which means that the last letter
	 * is assumed to be connected with the first letter. This also means that the
	 * smallest letter in the given array is greater than the last letter of the
	 * array and is also the first letter of the array.
	 * 
	 * Write a function to return the next letter of the given ¡®key¡¯.
	 * 
	 * Example 1:
	 * 
	 * Input: ['a', 'c', 'f', 'h'], key = 'f' Output: 'h' Explanation: The smallest
	 * letter greater than 'f' is 'h' in the given array. Example 2:
	 * 
	 * Input: ['a', 'c', 'f', 'h'], key = 'b' Output: 'c' Explanation: The smallest
	 * letter greater than 'b' is 'c'. Example 3:
	 * 
	 * Input: ['a', 'c', 'f', 'h'], key = 'm' Output: 'a' Explanation: As the array
	 * is assumed to be circular, the smallest letter greater than 'm' is 'a'.
	 * Example 4:
	 * 
	 * Input: ['a', 'c', 'f', 'h'], key = 'h' Output: 'a' Explanation: As the array
	 * is assumed to be circular, the smallest letter greater than 'h' is 'a'.
	 * 
	 */

	public static char searchNextLetter(char[] arr, char key) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == key) {
				return mid + 1 == arr.length ? arr[0] : arr[mid + 1];
			} else if (arr[mid] - 1 < key) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return arr[left] > key ? arr[left] : arr[right] > key ? arr[right] : arr[0];
	}

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}

}
