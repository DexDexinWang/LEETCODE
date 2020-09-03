
public class Solution389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution389().findTheDifference("abcd", "abcde"));
	}
    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        for(char c : s.toCharArray()) {
            sum1+= c -'a';
        }
        
        int sum2 = 0;
        for(char c : t.toCharArray()) {
            sum2+= c -'a';
        }
        
        return (char)(sum2 - sum1 + 'a');
    }
    
    public char findTheDifference1(String s, String t) {
        char res = 0;
        for(char c : s.toCharArray()) {
            res=(char) (res^c);
        }
        
        for(char c : t.toCharArray()) {
            res= (char) (res^c);
        }
        
        return res;
    }
}
