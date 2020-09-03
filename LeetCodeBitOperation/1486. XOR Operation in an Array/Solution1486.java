
public class Solution1486 {
	public static void main(String[] args) {
		System.out.println(new Solution1486().xorOperation(5, 3));
	}
	
	    public int xorOperation(int n, int start) {
	        int res = 0;
	        for(int i = 0; i < n; i++) {
	            res = res ^ (start + 2 * i);
	        }
	        return res;
	    }
	
}
