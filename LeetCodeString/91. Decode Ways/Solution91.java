
public class Solution91 {

	public static void main(String[] args) {
		Solution91 test = new Solution91();
		System.out.println(test.numDecodings("12121"));
	}
	
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int one = 1;
        int two = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int prev = s.charAt(i-1) - '0';
            int curr = s.charAt(i) - '0';
            prev = prev* 10 + curr;
            int temp = 0;
            if (curr >= 1 && curr <= 9) {
               temp += two;
            }
            
            if (prev >= 10 && prev <= 26) {
                temp += one;
            }
            one = two;
            two = temp;
        }
        
        return two;
    }
    
    /*
     * Follow Up
     * 
     * */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int one = 1;
        int two = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int prev = s.charAt(i-1) - '0';
            int curr = s.charAt(i) - '0';
            prev = prev* 10 + curr;
            int temp = 0;
            if (curr >= 1 && curr <= 9) {
               temp += two;
            }
            
            if (prev >= 10 && prev <= 26) {
                temp += one;
            }
            one = two;
            two = temp;
        }
        
        return two;
    }
}
