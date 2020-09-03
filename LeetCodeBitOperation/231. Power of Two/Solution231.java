
public class Solution231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int sum = 0;
        while(n!= 0) {
            sum++;
            n &=(n-1);
            if(sum >=2) return false;
        }
        return sum == 1;
    }
}
