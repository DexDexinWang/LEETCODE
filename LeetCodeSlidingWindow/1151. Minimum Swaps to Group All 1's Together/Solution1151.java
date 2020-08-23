
public class Solution1151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //sliding window represents the sub array with lenght n which is the total number of 1s.
    //SW will be strinked if the sub array length is n + 1
    //The total result will consider how many 0s in each sub array.
    public int minSwaps(int[] data) {
        if(data == null || data.length == 0) return 0;
        int size = data.length;
        int len = 0;
        for(int i = 0; i < size; i++) {
            len += data[i];
        }
        int left = 0;
        int right = 0;
        int totalOne = 0;
        int minMove = Integer.MAX_VALUE;
        while (right < size) {
            int curr = data[right];
            totalOne += curr;
            if(right - left + 1 >= len) {
                minMove = Math.min(minMove, len - totalOne);
                totalOne -= data[left++];
            }
            right++;
        }
        return minMove;
    }
}
