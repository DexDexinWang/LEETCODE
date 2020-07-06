
public class Solution990 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution990().equationsPossible(new String[] {"a==b","b!=a"});
	}

    public boolean equationsPossible(String[] equations) {
        int[] groups = new int[26];
        for(int i = 0; i < 26; i++) {
            groups[i] = i;
        }
        for(String equ: equations) {
	        int a = equ.charAt(0) - 'a';
	        int b = equ.charAt(3) - 'a';
	        boolean isEqual = equ.charAt(1) == '=';
            if(isEqual){
                int groupA = find(a, groups);
                int groupB = find(b, groups);
                if(groupA != groupB) {
                    groups[groupA] = groupB;
                }
            }
        }
        
        for(String equ: equations) {
	        int a = equ.charAt(0) - 'a';
	        int b = equ.charAt(3) - 'a';
	        boolean isEqual = equ.charAt(1) == '=';
            if(!isEqual){
                int groupA = find(a, groups);
                int groupB = find(b, groups);
                if(groupA == groupB) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int a, int[] groups) {
        if(a != groups[a]) {
            groups[a] = find(groups[a], groups);
        }
        return groups[a];
    }
	
	
	 public boolean equationsPossible1(String[] equations) {
	        Boolean[][] dp = new Boolean[26][26];
	        for(String equ: equations) {
	            char first = equ.charAt(0);
	            char second = equ.charAt(3);
	            boolean isEqual = equ.charAt(1) == '=';
	            int i = first -'a', j = second -'a';
	            if(i == j && !isEqual) return false;
	            
	            if(dp[i][j] == null) dp[i][j] = isEqual;
	            else if (dp[i][j] != isEqual) return false;
	            if(dp[j][i] == null) dp[j][i] = isEqual;
	            else if (dp[j][i] != isEqual) return false;
	        }
	        
	        for(int k = 0; k < 26; k++) {
	            for(int i = 0; i < 26; i++) {
	                for(int j = 0; j < 26; j++) {
	                	if(dp[i][k] == null || dp[k][j] == null) {
	                		continue;
	                	} else if(dp[i][k] == true && dp[k][j] == true) {
	                        if(dp[i][j] == null) {
	                            dp[i][j] = true;
	                        } else if (dp[i][j] == false) {
	                            return false;
	                        }
	                    } else if(dp[i][k] == false && dp[k][j] == false) {
	                        
	                    } else if (dp[i][k] == false || dp[k][j] == false) {
	                        if(dp[i][j] == null) {
	                            dp[i][j] = false;
	                        } else if (dp[i][j] == true) {
	                            return false;
	                        }
	                    }
	                }
	            }
	        }
	        return true;
	    }
}
