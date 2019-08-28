
public class Solution69 {

	public static void main(String[] args) {
		mySqrt(8);
	}

	
	public static int mySqrt(int x) {
        return help(x, 0, x);
    }
	
	private static int help(int x, int left, int right) {
		if (right - left <= 1) {
			if (x < left * left) {
				return left - 1;
			} else if (x >= right * right) {
				return right;
			} else {
				return left;
			}
		}
			
		int mid = left + (right - left) / 2;
		if (mid == x /mid) {
			return mid;
		} else if (mid > x / mid) {
			return help(x, left, mid - 1);
		} else {
			return help(x, mid, right);
		}	
	}
}
