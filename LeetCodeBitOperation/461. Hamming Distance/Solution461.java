
public class Solution461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int res = 0;
        while(temp!= 0) {
            if((temp & 1)  == 1) {
                res++;
            }
            temp >>= 1;
        }
        return res;
    }
}
