
public class Solution1052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1052().maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3));
	}
	
    //Sliding window with X size to find maximum customers 
    //The sliding window should be shrinked if the range is greater than X;
    //Moving slding window will record the maximum customer in K mins what will be used in final result.
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        int sum = 0,bestSum = 0;
        int left = 0, right = 0;
        while(right < customers.length) {
            sum+= grumpy[right] == 1 ? customers[right] : 0;
            if(right - left + 1 > X) {
                sum-= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
            if(bestSum < sum) {
                bestSum = sum;
            }
            right++;
        }
        
        for(int i = 0; i < customers.length; i++) {
        	if(grumpy[i] == 0) bestSum+= customers[i];
        }
        return bestSum;
    }
}
