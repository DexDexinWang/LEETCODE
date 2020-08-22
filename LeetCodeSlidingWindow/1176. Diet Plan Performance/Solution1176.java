
public class Solution1176 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Sliding window
    //The window range indicate the total calories consumed;
    //The range will be shrinked if a new daily colory is added.
    //The result will be added for each sliding window move
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(calories == null || calories.length == 0) return 0;
        int left = 0, right = 0;
        int sumK = 0;
        int res = 0;
        while(right < calories.length) {
            sumK += calories[right];
            if(right - left + 1 == k) {
                res += sumK > upper ? 1 : (sumK < lower ? -1: 0);
                sumK-= calories[left++];
            }
            right++;
        }
        return res;
    }
}
