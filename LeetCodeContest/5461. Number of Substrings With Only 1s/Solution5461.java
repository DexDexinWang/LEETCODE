
public class Solution5461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5461().numSub("1111111111011010011"));
	}
    public int numSub(String s) {
        double res = 0;
        char[] chars = s.toCharArray();
        double len = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i]=='1') {
                len++;
                res+=len;
            } else {
                len = 0;
            }
        }
	        return  (int)(res % (Math.pow(10,9) + 7));
    }
}
