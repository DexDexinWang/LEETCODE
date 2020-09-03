
public class Solution693 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while(n > 0) {
        	if(n % 2 != cur) return false;
        	cur = n % 2;
        	n /=2;
        }
        return true;
    }
}
