
public class MaxSumSubArrayofSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public static int findMaxSumSubArray(int k, int[] arr) {
		    //it should assume that all input inger should be positive
		    int max = -1;
		    int sum = 0;
		    for(int i = 0; i < arr.length; i++) {
		      sum+=arr[i];
		      if(i >= k - 1) {
		        max = Math.max(max, sum);
		        sum -= arr[i-k+1]; 
		      }
		    }
		    return max;
		  }
}
