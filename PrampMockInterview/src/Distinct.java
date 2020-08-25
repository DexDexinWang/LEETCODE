
public class Distinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Distinct().deletionDistance("heat", "hit"));
	}
	  //bruteforce solution with DFS
	  //Levels: I will delete one character in str1 or str2 ==> M+n where n is the len1 m is len2
	  //status in each level: 2
	  //Time complexity: O(2^n) space compelxity:O(M+n) call stacks
	  
	  //DP solution
	  //DP[i][j] repsent the minimum steps to make both sub str1 and substr2 are equal 
	  //sub-str1 (0 ... i - 1)  sub-str2(0....j-1);
	  //Base cases: DP[0][0] = 0  , DP[0][j] j steps  DP[i][0] i steps
	  //Induction rule: DP[i][j] = case 1  str1.charAt(i-1) == str2.charAt(j-1)  dp[i-1][j-1]
	  //                           case 2  str1.charAt(i-1) != str2.charAt(j-1)
	  //                                      Min(DP[i-1][j], DP[i][j-1]) + 1; 
	  //Time compleixty: O(n*m) ,  Space O(n*m); 
	  
	  //Optimized with 1-D array, get shorter str1 as index for dp[];
	  //Time compelxity: O(n*m), Space O(min(n,m));
	  
	  static int deletionDistance(String str1, String str2) {
	    //Corner cases 
	    if(str1 == null || str2 == null) return 0;
	    if(str1.length() == 0) return str2.length();
	    if(str2.length() == 0) return str1.length();
	    //short 
	    String shorter = (str1.length() < str2.length())? str1 : str2;
	    String longer = (str1.length() >= str2.length())? str1 : str2;
	    //1D arry for shorter arry size is len + 1 // ""
	    int[] dp = new int[shorter.length() + 1];
	    //Init values 1D arry
	    for(int j = 0; j <= shorter.length(); j++) {
	      dp[j] = j;
	    }
	    
	    //For outer loop is to consider sub string for longer string from 1 to len2 
	    for(int i = 1; i <= longer.length(); i++) {
	      int[] temp = new int[shorter.length() + 1];
	      temp[0] = i;
	      //Create temp for temp result. 
	      for(int j = 1; j <= shorter.length(); j++) {
	         if(longer.charAt(i-1) == shorter.charAt(j-1)) {
	           temp[j] = dp[j - 1];
	         } else {
	           temp[j] = Math.min(temp[j-1],dp[j]) + 1;
	         }
	      }
	      dp = temp; // always keep current result.
	    }
	    return dp[shorter.length()];
	  }
}
