
public class Solution4 {

	public static void main(String[] args) {
		int[] input1 = new int[] {1,3};
		int[] input2 = new int[] {2};
		System.out.print(findMedianSortedArrays1(input1, input2));
	}
	
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
		int len2 = nums2.length;
        int i = 0;
        int j = 0;
        int[] res = new int[len1 + len2];
        int k = 0;
        while (i < len1 && j < len2) {
        	if (nums1[i] < nums2[j]) {
        		res[k++] = nums1[i++];
        	} else {
        		res[k++] = nums2[j++];
        	}
        }
        while (i < len1) {
        	res[k++] = nums1[i++];
        }
        while (j < len2) {
        	res[k++] = nums2[j++];
        }
        return (res[(len1 + len2 - 1) / 2] + res[(len1 + len2) / 2]) /2.0;
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//assume nums1 and nums2 are not null, also k > 0
		int len1 = nums1.length;
		int len2 = nums2.length;
		return (findKthElements(nums1, nums2, 0, 0, (len1 + len2 + 1)/2)+findKthElements(nums1, nums2, 0, 0, (len1 + len2 + 2)/2)) / 2.0;
	}
	
	public static int findKthElements(int[] nums1, int[] nums2, int i, int j, int k) {
		if (i >= nums1.length) {
			return nums2[j + k - 1];
		} 
		if (j >= nums2.length) {
			return nums1[i + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}
		int minValue1 = (i + k/2 - 1) < nums1.length ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
		int minValue2 = (j + k/2 - 1) < nums2.length ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;
		if (minValue1 < minValue2) {
			return findKthElements(nums1, nums2, i + k/2, j, k - k/2);
		} else {
			return findKthElements(nums1, nums2, i, j + k/2, k - k/2);
		}
	}
}
