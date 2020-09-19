
public class Solution680 {

	public static void main(String[] args) {
		Solution680 test = new Solution680();
		System.out.println(test.validPalindrome("abc"));
	}

	
    public boolean validPalindrome(String s) {
        int[] ps = new int[]{0,s.length() - 1};
        if(!validPalidrome(s, ps)) {
            int[] temp1 = new int[]{ps[0]+1, ps[1]};
            int[] temp2 = new int[]{ps[0], ps[1]-1};
            return validPalidrome(s,temp1) || validPalidrome(s,temp2);
        }
        return true;
    }
    
    public boolean validPalidrome(String s, int[] ps) {
        while(ps[0] < ps[1]) {
            if(s.charAt(ps[0]) != s.charAt(ps[1])) {
                return false;
            }
            ps[0]++;
            ps[1]--;
        }
        return true;
    }
}
