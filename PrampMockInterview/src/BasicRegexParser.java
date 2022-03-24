
public class BasicRegexParser {

	  /*
	  . could inciate any one character
	  * could inciate N numbers of the previous character (0 <= N <= inf)
	  DFS 
	  I will traverse char 1 by 1 in both text and pattern with 2 pointers.  i  and j
	  1. if text[i] == pattern[j] move both i and j ==> i++, j++
	  2. if text[i] != pattern[j]  need to check next 2 characters  pattern[j] and pattern[j+1] 
	     2.a. pattern[j] ==  '.'  ==> i++, j++
	     2.b. patther[j + 1] == '*'  ==> consider pattern[j] 0 to n times. n could be len of the pattern. 
	                                --> make some branches. 
	                                --> if any branch return true. that will be true. otherwise that will be false;
	                                
	       
	  
	   acd 
	     i
	   ab*c. 
	       j
	   #1
	   assume b appear 0 to n times. 
	   a.*c
	   abbbbc
	   O(n^2)
	   
	      '' a . * c
	      
	  ''   t f f f f
	   a   f t f f f 
	   b   f f t 
	   b   f
	   b
	   b
	   c
	   
	   
	   
	       '' a b * c .
	   ''  t  f f f f f
	   a   f  t f t f t
	   c   f  f f t t t
	   d   f  f f t f t
	   
	   
	   base case:dp[0][0] = true;
	   induction rule: iftext[i] == pattern[j] check dp[i+1][j+1] text[i-1] == pattern[j-1] 
	                   2. pattern[j] ==  '.' dp[i+1][j+1] = dp[i-1][i-1]
	                   3. patther[j + 1] == '*' check previous status from dp[i+1][j-1] || dp[i][j+1]
	                    finally return dp[end][end]
	  */
	  
	static boolean isMatch(String text, String pattern) {
	    int len1 = text.length();
	    int len2 = pattern.length();
	    
      if(len1 == 0) {
        return len2 == 0 || len2 == 1 && pattern.charAt(0) == '.' || len2 == 2 && pattern.charAt(1) == '*';
      }
	    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
	    dp[0][0] = true;
	    for(int i = 1; i <= len1; i++) {
	      for(int j = 1; j <= len2; j++) {
	        char a = text.charAt(i-1);
	        char b = pattern.charAt(j-1);
	        if(a == b) {
	          dp[i][j] = dp[i-1][j-1];
	          continue;
	        } else {
	          if(b == '.') {
	            dp[i][j] = dp[i][j - 2];
	          } else if (b == '*') {
	            dp[i][j] = dp[i][j-2] || dp[i-1][j];
	          }
	        }
	      }
	    }
	    return dp[len1][len2];
	  }


	  public static void main(String[] args) {
	    System.out.println(isMatch( 
	    		"aba", "a.a"));
	  }

}
