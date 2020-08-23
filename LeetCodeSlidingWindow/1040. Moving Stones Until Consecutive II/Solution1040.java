import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1040 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution1040().numMovesStonesII(new int[] {6,5,4,3,10})));
	}
    //The given stones could be transferred as sliding window array
    //Sliding window size =  represent in (number of stones = k) range, how many stones should swap. 
    //Siiding window will be shrinked
    //The result find maxSwap and minSwap
    public int[] numMovesStonesII1(int[] stones) {
        int maxPosition = Integer.MIN_VALUE;
        int minPosition = Integer.MAX_VALUE;
        for(int i = 0; i < stones.length; i++) {
            maxPosition = Math.max(maxPosition, stones[i]);
            minPosition = Math.min(minPosition, stones[i]);
        }
        int len = maxPosition - minPosition + 1;
        int[] arr = new int[len];
        for(int i = 0; i < stones.length; i++) {
            arr[stones[i]-minPosition] = 1;
        }
        
        int range = stones.length; 
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] count = new int[2];
        while(right < len) {
            count[arr[right]]++;
            while(right - left + 1 == range) {
            	if(count[1] == range) return new int[]{0,0};
            	if(!(count[1] == range - 1 && (arr[left] == 0 || arr[right] == 0))) { 
	                min = Math.min(min, count[0]);
	                max = Math.max(max, count[1]);
            	}
                count[arr[left++]]--;
            }
            right++;
        }
        
        return new int[]{min, max};
    }
    
    public int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        int i = 0, n = A.length, low = n;
        int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while (A[j] - A[i] >= n) ++i;
            if (j - i + 1 == n - 1 && A[j] - A[i] == n - 2)
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[] {low, high};
    }
}
