import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new Solution1310().xorQueries(new int[] {1,3,4,8}, new int[][] {{0,1},{1,2},{0,3},{3,3}} )));
	}
    public int[] xorQueries(int[] arr, int[][] queries) {
        for(int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i-1];
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] curr = queries[i];
            if(curr[0] == 0) {
            	res[i] = arr[curr[1]];
            } else {
            	res[i] = arr[curr[0] -1] ^ arr[curr[1]];
            }
        }
        return res;
    }
    
    
}
