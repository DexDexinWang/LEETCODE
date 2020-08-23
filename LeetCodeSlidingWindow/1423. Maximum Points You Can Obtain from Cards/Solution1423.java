
public class Solution1423 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution1423().maxScore(new int[]{1,2,3,4,5,6,1}, 3);
	}
    //SW represent k size of sub contigious array.
    //SW will move left side if size is k;
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while(right < cardPoints.length + k - 1) {
            int tempRight = right % cardPoints.length;
            sum += cardPoints[tempRight];
            if(right - left + 1 == k || (tempRight < left && tempRight + cardPoints.length - left == k)) {
                max = Math.max(sum, max);
                sum -= cardPoints[left++];
            }
            right++;
        }
        return max;
    }
}
