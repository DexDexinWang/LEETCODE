
public class Solution441 {

	public static void main(String[] args) {
		int n = 1804289383;
		System.out.print(n);

	}

	public static int arrangeCoins(int n) {
		//corner case
		if (n == 0) {
			return 0;
		} 
		int cur = 1; 
		int rem = n - 1;
		while(rem >= cur +1) {
			cur++;
			rem -= cur;
		}
		return cur;
    }

	// k(k+1)/2 = n 
	public static int arrangeCoins1(int n) {
		if (n== 0) {
			return 0;
		}
		int i = 1;
		int j = n;
	
		while (i < j) {
			int mid = i + (j - i) / 2;
			if ((mid * (mid + 1) * 0.5) <= n) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		return i - 1;
	}
}
