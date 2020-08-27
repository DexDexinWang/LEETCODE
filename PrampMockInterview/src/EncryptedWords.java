
public class EncryptedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(encry("abcxcba"));
	}
	  static int index = 0;
	  public static String encry(String word) {
	    char[] chars = new char[word.length()];
	    encryHelper(word, 0, word.length()-1, chars);
	    return new String(chars);
	  }
	  
	  public static void encryHelper(String str, int left, int right, char[] chars) {
	    if(left > right) return ;
	    if(left == right) {
	      chars[index++] = str.charAt(left);
	      return;
	    }
	    int mid = left + (right -left)/2;      
	    chars[index++] = str.charAt(mid);      
	    encryHelper(str, left, mid -1, chars);  
	    encryHelper(str, mid+1, right, chars); 
	  }
	  
	  
		  
}
