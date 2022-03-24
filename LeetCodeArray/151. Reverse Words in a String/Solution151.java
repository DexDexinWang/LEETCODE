import java.util.Arrays;

public class Solution151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution151 s = new Solution151();
		System.out.print(s.reverseWords("the sky is blue"));
	}

	
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1)  {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        swap(chars, 0, len - 1);
        int i = 0;
        //all characters in left side of i are reversed words 
        //all characters in right side of j are not checked
        //remove leading 
        
        
        while(i < len) {
            if(chars[i] != ' ') {
                break;
            }
            i++;
        }
        int start = i;
        int j = i;
        while(j < len) {
            if(chars[j] == ' ' && chars[j - 1] != ' ') {
                swap(chars, i, j-1);
                i = j - 1;
            }
            if(i != j && chars[j] != ' ' && chars[j - 1] == ' ') {
                i = j;
            }
            j++;
        }
        if(chars[j-1] != ' ')  {
            swap(chars, i, j-1);
            i = j-1;
        }
        
        char[] res = Arrays.copyOfRange(chars, start, i+1);
        return new String(res);
        
    }
    
    private void swap(char[] chars, int i, int j) {
        while(i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
