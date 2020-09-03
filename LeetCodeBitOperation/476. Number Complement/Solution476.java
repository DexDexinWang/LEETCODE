
public class Solution476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution476().findComplement(3));
	}
	
    public int findComplement(int num) {
        int temp = num;
        int mask = 0;
        while(temp != 0) {
            mask = (mask << 1) + 1;
            temp >>=1;
        }
        return mask ^ num;
    }
}
