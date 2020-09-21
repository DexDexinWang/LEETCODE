import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution301 test = new Solution301();
		System.out.println(test.removeInvalidParentheses("()())()"));
	}
	int globalMin = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), visited);
        return res;
    }
    
    private void dfs(String s, int i, List<String> res, StringBuilder sb, Set<String> visited) {
        if(i == s.length()) {
            String temp = sb.toString();
            if(isValid(temp) && visited.add(temp)) {
            	int minDelete = s.length() - temp.length();
            	if( minDelete < globalMin) {
            		res.clear();
            		globalMin = minDelete;
            		res.add(temp);
            	} else if (minDelete == globalMin) {
            		res.add(temp);
            	}
            }
            return;
        }
        char curr = s.charAt(i);
        if(curr == '(' || curr == ')') {
            dfs(s, i + 1, res, sb, visited);
        } 
        sb.append(curr);
        dfs(s, i + 1, res, sb, visited);
        sb.deleteCharAt(sb.length() - 1);
    } 
    
    private boolean isValid(String s) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count1++;
            } else if (s.charAt(i) == ')') {
                count1--;
            }
            if(count1 < 0) {
                count2++;
                count1++;
            }
        }
        return count2 + count1 == 0;
    }
}
