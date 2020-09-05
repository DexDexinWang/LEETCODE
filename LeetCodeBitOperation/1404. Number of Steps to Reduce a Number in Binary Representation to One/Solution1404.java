
public class Solution1404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numSteps(String s) {
        int res = 0, carry = 0;
        for(int i = s.length() - 1; i >0;i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1) {
                res++;
                carry=1;
            }
        }
        return res + carry;
    }
}
