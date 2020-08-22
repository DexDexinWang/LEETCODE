import java.lang.reflect.Array;
import java.util.Arrays;

public class SumKContiguous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static double[] findAverages(int K, int[] arr) {
	    double[] result = new double[arr.length - K + 1];
	    for (int i = 0; i <= arr.length - K; i++) {
	      // find sum of next 'K' elements
	      double sum = 0;
	      for (int j = i; j < i + K; j++)
	        sum += arr[j];
	      result[i] = sum / K; // calculate average
	    }

	    return result;
	  }
	public static double[] findAverages1(int k, int[] arr) {
		if (arr==null || arr.length <= k) return new double[] {};
		double sum = 0;        
		double[] res = new double[arr.length - k + 1];
		for(int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if(i >= k - 1) {
				res[i-k] = sum /k;
				sum -= arr[i-k+1];
			}
		}
		return res;
	}
}
