
public class Solution917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution917 s = new Solution917();
		System.out.println(s.reverseOnlyLetters("7_28]"));
	}

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
            while(i < j && !isEnglishLetter(chars[i])) {
                i++;
            }
            while (i < j && !isEnglishLetter(chars[j])) {
                j--;
            }
            swap(chars, i , j);
            i++;
            j--;
        }
        return new String(chars);
    }
    
    private boolean isEnglishLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
