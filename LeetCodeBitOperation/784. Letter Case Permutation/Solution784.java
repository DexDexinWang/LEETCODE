import java.util.LinkedList;
import java.util.List;

public class Solution784 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        dfs(S, 0, new StringBuilder(), res);
        return res;
    }
    
    public void dfs(String S, int index, StringBuilder sb, List<String> res) {
        if(index == S.length()) {
            res.add(sb.toString());
            return;
        }
        char c = S.charAt(index);
        if(Character.isLetter(c)) {
            sb.append(Character.toLowerCase(c));
            dfs(S, index + 1, sb, res);
            sb.deleteCharAt(sb.length()-1);
            
            sb.append(Character.toUpperCase(c));
            dfs(S, index + 1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(c);
            dfs(S,index + 1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
