
public class Solution1304 {

	class Solution {
	    public int[] sumZero(int n) {
	        int[] res = new int[n]; 
	        int validNumber = 1;
	        for(int i = 0; i < n/2*2; i+=2) {
	            res[i] = validNumber;
	            res[i+1] = -validNumber;
	            validNumber++;
	        }
	        if(n % 2 == 1) {
	            res[n - 1] = 0;
	        }
	        return res;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
