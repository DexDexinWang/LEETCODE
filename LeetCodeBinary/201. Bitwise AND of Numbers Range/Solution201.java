
public class Solution201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Find the first common continue digits. 
	class Solution {
	    public int rangeBitwiseAnd(int m, int n) {
	        int i = 0;
	        while (m != n) {
	            m = m >> 1;
	            n = n >> 1;
	            i++;
	        }
	        return (m << i);
	    }
	}

}
