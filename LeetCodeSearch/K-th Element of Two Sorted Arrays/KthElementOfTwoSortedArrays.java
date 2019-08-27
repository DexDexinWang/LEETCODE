import java.util.Arrays;

import integer.RandomIntegerArray;
public class KthElementOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] input1 = RandomIntegerArray.sortedNoDuplicatedArrayGen(5, 1, 10);
		int[] input2 = RandomIntegerArray.sortedNoDuplicatedArrayGen(5, 1, 10);
		System.out.print(Arrays.toString(input1));
		System.out.print(Arrays.toString(input2));
		System.out.print(findKth2(input1, input2, 5));
	}
	
	
	public static int findKth(int[] nums1, int[] nums2, int k) {
		//solution1 : merge them and find k directly.
		//corner cases
		if (nums1 == null && nums2 == null) {
			return -1;
		}
		int i = 0;
		int j = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] res = new int[len1 + len2];
		int index = 0;
		while (i < len1 && j < len2) {
			if (nums1[i] < nums2[j]) {
				res[index++] =nums1[i++];
			} else {
				res[index++] =nums1[j++];
			}
		}
		while (i < len1) {
			res[index++] =nums1[i++];
		}
		while (j < len2) {
			res[index++] =nums1[j++];
		}
		return res[k - 1];
	}

	public static int findKth2(int[] nums1, int[] nums2, int k) {
		//corner cases
		if (nums1 == null && nums2 == null) {
			return -1;
		}
		return help2 (nums1, nums2, 0, 0, k);
	}
	
	private static int help2 (int[] nums1, int[] nums2, int i, int j, int k) {
		if ( i>= nums1.length) {
			return nums2[j + k - 1];
		} 
		if ( j >= nums2.length) {
			return nums1[i + k -1];
		}
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}
		//k/2 - 1  because k is counted from 1;
		int minValue1 = (i + k/2 - 1 < nums1.length) ? nums1[i + k/2 -1] : Integer.MAX_VALUE;  
		int minValue2 = (j + k/2 - 1 < nums2.length) ? nums2[j + k/2 -1] : Integer.MAX_VALUE;
		if (minValue1 < minValue2) {
			return help2(nums1, nums2, i + k/2, j, k-k/2);
		} else {
			return help2(nums1, nums2, i, j + k/2, k-k/2);
		}
	}
	// Time complexity O(log m + n) 
}
