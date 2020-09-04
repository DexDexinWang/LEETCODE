
public class Solution190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res<<=1;
            res |= (n & 1);
            n >>=1;
        }
        return res;
    }
}
