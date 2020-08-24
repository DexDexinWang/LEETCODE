import java.util.Arrays;

public class PrintDistanceSrouceTarget {

	/**
	Diff Between Two Strings
	Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert from source to target that uses the least edits possible.

	For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"

	More formally, for each character C in source, we will either write the token C, which does not count as an edit; or write the token -C, which counts as an edit.

	Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.

	At the end, when reading the tokens from left to right, and not including tokens prefixed with a minus-sign, the letters should spell out target (when ignoring plus-signs.)

	In the example, the answer of A B -C D -E F +F G +H has total number of edits 4 (the minimum possible), and ignoring subtraction-tokens, spells out A, B, D, F, +F, G, +H which represents the string target.

	If there are multiple answers, use the answer that favors removing from the source first.

	Constraints:

	[time limit] 5000ms
	[input] string source
	2 ¡Ü source.length ¡Ü 12
	[input] string target
	2 ¡Ü target.length ¡Ü 12
	[output] array.string

	ABCD
	BCD

	+A B C D (insert and delete only)

	row = source,  
	col = target
	       '' A  B  C  D  E  F  G
	    '' 0  1  2  3  4  5  6  7
	    A  1  0  
	    B  2
	    D  3
	    F  4  
	    F  5
	    G  6
	    H  7                          
	    
	    
	        ''       A    B      C        D      E      F      G
	    ''  ¡®¡¯     ¡®-A¡¯  ¡®-A-B¡¯  ¡®..-C¡¯ ¡®..-D¡¯ ¡®..-E¡¯ ¡®..-F¡¯ ¡®..-G¡¯
	    A  ¡®-A¡¯    ¡®A¡¯  
	    
	    
	    B  ¡®..-B¡¯
	    D  ¡®..-D¡¯
	    F  ¡®..-F¡¯
	    F  ¡®..-F¡¯
	    G  ¡®..-G¡¯
	    H  ¡®..-H¡¯                    
	    

	Delete rule: dp[i-1][j] dp[i][j-1]


	Baase cases:
	DP1[i][j] respents the numimum cost to convert source to target from source[0 to i - 1] and target[0 to j -1]
	DP1[0][0] = 0;
	DP1[i][0] = i;
	DP1[0][j] = j;

	Induction rules£º
	DP1[i][j] = case 1  source[i-1] = target[j-1],  ====> DP[i-1][j-1]
	           case 2  sourse[i-1] != tareget[j-1] ====> Min.step(Dp[i-1][j], DP[i][j-1]) + 1 
	           
	Baase cases:
	DP2[i][j] respents the actual action to convert source to target from source[0 to i - 1] and target[0 to j -1] that corresponding to to DP1
	DP2[0][0] = ''; 
	DP2[i][0] = '-A','-A-B....';
	DP2[0][j] = ¡®-A¡¯, '-A-B....';

	Induction rules£º
	DP2[i][j] = case 1  source[i-1] = target[j-1],  ====> DP2[i-1][j-1] + ¡®A¡¯  
	            case 2  sourse[i-1] != tareget[j-1] ====> if Dp1[i-1][j] less cost, DP[i-1][j] + '-' + character
	                                                         Dp1[i][j- 1] lest cost, DP[i][j] + '-' + character
	                                                         

	case 2  sourse[i-1] != tareget[j-1] ====> 
	if Dp1[i-1][j] less cost, DP[i-1][j] + '-'|¡®+¡¯ + character   
	Dp1[i][j- 1] lest cost, DP[i][j] + '-' + character

	if (len1 - i) >= (len2 -j)? - : +

	print out result 

	ABC - source
	BCD

	-A B -C +D <- pick this one
	+A B -D +C
	 */
	
	  /**
	  function diffBetweenTwoStrings(source, target):
	    ans = []
	    i = 0
	    j = 0
	    # We are always considering strings source[i:] and target[j:]
	    while i < source.length AND j < target.length:
	        if source[i] == target[j]:
	            # Write the string with no edits
	            ans.push(source[i])
	            i += 1
	            j += 1
	        else:
	            # We have to decide whether to subtract source[i],
	            # or add target[j].
	            if dp(i+1, j) <= dp(i, j+1):
	                ans.push('-' + source[i])
	                i += 1
	            else:
	                ans.push('+' + target[j])
	                j += 1

	    while j < target.length:
	        ans.push('+' + target[j])
	        j += 1

	    return " ".join(ans)
	  
	  */
	
	public static void main(String[] args) {
		  String[] ans = new PrintDistanceSrouceTarget().convert("AG", "ABCDEFG");
		  //    String ans = new Solution().convert("source", "target");
		    //  ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"]

		    
		    //Time compelxity: O(2^(n+m))        Space: O(n+m)  call in stack 
		    //Time compelxity: O((n*m)*(n+m))    Space: O(n*m)*(n+m)  matrix + string
		    
		    System.out.println(Arrays.toString(ans));  
		  }
	
	public String[] convert(String source, String target) {
	    int len1 = target.length();
	    int len2 = source.length();
	    
	    
	    int[][] dp1 = new int[len1+1][len2+1];
	    String[][] dp2 = new String[len1+1][len2+1];
	    
	    dp1[0][0] = 0;
	    dp2[0][0] = "";
	    
	    for(int i = 1; i < len1 + 1; i++) {
	      dp1[i][0] = i;
	      dp2[i][0] = dp2[i-1][0] + "-" + target.charAt(i - 1)+",";
	    }
	    
	    for(int i = 1; i < len2 + 1; i++) {
	      dp1[0][i] = i;
	      dp2[0][i] = dp2[0][i-1] + "-" + source.charAt(i - 1)+",";
	    }
	    
	    for(int r = 1; r < len1 + 1; r++) {
	      for(int c = 1; c < len2 + 1; c++) {
	        if(target.charAt(r-1) == source.charAt(c-1)) {
	          dp1[r][c] = dp1[r-1][c-1];
	          dp2[r][c] = dp2[r-1][c-1] + source.charAt(c-1)+",";
	        } else {
	          if (dp1[r-1][c] < dp1[r][c - 1]) {
	            dp1[r][c] = dp1[r-1][c] + 1;
	            dp2[r][c] = dp2[r-1][c] + (len1 - (r-1) > len2 - c ? "+" + target.charAt(r-1) : "-" + source.charAt(c-1)) + ","; 
	          } else {
	            dp1[r][c] = dp1[r][c - 1] + 1;
	            dp2[r][c] = dp2[r][c - 1] + (len1 - r > len2 - (c-1) ? "+" + target.charAt(r-1) : "-" + source.charAt(c-1)) + ","; 
	          }
	        }
	      }
	    }
	    return dp2[len1][len2].split(",");//post processing
	  }
}
