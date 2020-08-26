
public class ComparingStringsContainingBackspaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compare("xy#z", "xzz#");
	}
	  public static boolean compare(String str1, String str2) {
		    char[] chars1 = convert(str1);
		    char[] chars2 = convert(str2);
		    for(int i = 0; i < Math.min(chars1.length, chars2.length);i++) {
		      if(chars1[i] != chars2[i]) {
		        return false;
		      }
		    }
		    return true;
		  }

		  public static char[] convert(String str) {
		    char[] chars = str.toCharArray();
		    int i = 0;
		    int j = 0;
		    while(j < chars.length) {
		      if(chars[j] != '#') {
		        swap(chars, i, j);
		        i++;
		        j++;
		      } else {
		        i--;
		        j++;
		      }
		    }
		    while(i < chars.length){
		      chars[i++] = '#';
		    }
		    return chars;
		  }

		  public static void swap(char[] chars , int x , int y) {
		    char temp = chars[x];
		    chars[x] = chars[y];
		    chars[y] = temp;
		  }
		  
		  
		  public static boolean compare1(String str1, String str2) {
			    // use two pointer approach to compare the strings
			    int index1 = str1.length() - 1, index2 = str2.length() - 1;
			    while (index1 >= 0 || index2 >= 0) {

			      int i1 = getNextValidCharIndex(str1, index1);
			      int i2 = getNextValidCharIndex(str2, index2);

			      if (i1 < 0 && i2 < 0) // reached the end of both the strings
			        return true;

			      if (i1 < 0 || i2 < 0) // reached the end of one of the strings
			        return false;

			      if (str1.charAt(i1) != str2.charAt(i2)) // check if the characters are equal
			        return false;

			      index1 = i1 - 1;
			      index2 = i2 - 1;
			    }

			    return true;
			  }

			  private static int getNextValidCharIndex(String str, int index) {
			    int backspaceCount = 0;
			    while (index >= 0) {
			      if (str.charAt(index) == '#') // found a backspace character
			        backspaceCount++;
			      else if (backspaceCount > 0) // a non-backspace character
			        backspaceCount--;
			      else
			        break;

			      index--; // skip a backspace or a valid character
			    }
			    return index;
			  }
}
