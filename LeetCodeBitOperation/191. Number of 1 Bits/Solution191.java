
public class Solution191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution191().hammingWeight1(14));
	}
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            count += n & 1;
            n>>=1;
        }
        return count;
    }
    
    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
