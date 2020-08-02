
public class Solution5478 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5478().maxSum(new int[] {2,4,5,8,10}, new int[] {4,6,8,9})); 
	}
    public int maxSum(int[] nums1, int[] nums2) {
    	int i = 0;
        int len1 = nums1.length;
        double count1 = 0;
        int j = 0;
        int len2 = nums2.length;
        double count2 = 0;
        double max = 0;
        while (i < len1 || j < len2) {
            if(i < len1 && (j >= len2 || nums1[i] < nums2[j])) {
                count1 += nums1[i++];
            } else if (j < len2 && (i >= len1 || nums1[i] > nums2[j])) {
                count2 += nums2[j++];
            } else {
                max += Math.max(count1, count2);
                count1 = nums1[i++];
                count2 = nums2[j++];
            }
        }
        max += Math.max(count1, count2);
        return (int)(max % ((Math.pow(10,9)) + 7));
    }
}
