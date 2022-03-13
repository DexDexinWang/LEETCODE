import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DecryptMessage {
	
	  /*
    Encryption Steps:
    1. get ASCII value for each character
    2. First character : add + 1
       Other characters: current value = ASCII of (charachter) + previous value.
    3. convert each value as small letter by substrct n*26 until the number is between the range from 97 +  122
    
    Decryption steps:
    First we have to reverse the steps, from 3 to 1;
    1. check characters from 2 to n;
       Case 2: Other characters - 110 + (n * 26)  n = 1  --> 136  --> 162 --> 188 -> 214 > (current value + previous values) > 210 
    2. caluclate ASCII code by check values from end to beiging such as (current value - previous value) 
    3. convert ASCII code to characters.  Case 1: First charcter - 1 to get the orginal first character.  if encrypted character is 'a' then if number is 96 that will be 122('z') 
      case 2: convert character directly back to ASCKII code. 
    
    110 = 114 + 100 - 26*n
    
    110 -100 = 10 + 26*n   (current Value - previou values)  + 26* n that is from 97 to 122. 
    n= 4 -> 14 + 26*4 = 114  
   
   111 - previous total in 2nd step. 
    
    example 1
    100   -  
    110  110 + n*26 until there that is bigger than (current value + previous value) -> 110 * 4 * 26 = 224 > 220
    111  111 + n*26 until there is bigger than ....     n * 26 >= 331 - 111 = 8 * 26 + 111 = 234 + 111 = 345
    
    
    
    optimized for each characters () 
    
    Solution: 
    for loop to traverse values from 1st index to n-1 index 
    1. current number -> current value - previous record value + n * 26 until there is in the range from 97 to 122  
    2. record the total for next character. 
    3. convert integer as character.
    
    Then add first charcter
    Time complexity: O(n) where n is number of charcters.
    Space complexity: O(n) 
  */
  static String decrypt(String word) {
    if(word == null || word.length() == 0) {
      return "";
    }
    char[] chars = word.toCharArray();
    int previousTotal = chars[0];
    for(int i = 1; i < chars.length; i++) {
      int temp = chars[i];
      while(temp - previousTotal < 97) {
        temp += 26;
      }
      chars[i] = (char)(temp - previousTotal);
      previousTotal = temp; 
    }
    chars[0] = chars[0] == 'a'? 'z': (char)(chars[0] - 1);
    return new String(chars);
  }

  public static void main(String[] args) {
    System.out.println(DecryptMessage.decrypt("dnotq"));
  }

}
