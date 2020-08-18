import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    Map<Character,char[]> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', new char[] {'a','b','c'});
        map.put('3', new char[] {'d','e','f'});
        map.put('4', new char[] {'g','h','i'});
        map.put('5', new char[] {'j','k','l'});
        map.put('6', new char[] {'m','n','o'});
        map.put('7', new char[] {'p','q','r','s'});
        map.put('8', new char[] {'t','u','v'});
        map.put('9', new char[] {'w','x','y','z'});
        res = new LinkedList<>();
        if(digits.length() == 0) return res;
        letterCombinations(digits.toCharArray(), 0, new StringBuilder());
        return res;
    }
    
    public void  letterCombinations(char[] chars, int index, StringBuilder sb) {
    	if(index == chars.length) {
    		res.add(sb.toString());
            return;
    	}
    	char[] temp = map.get(chars[index]);
    	for(int i = 0; i < temp.length; i++) {
    		sb.append(temp[i]);
    		letterCombinations(chars, index + 1, sb);
    		sb.deleteCharAt(sb.length() -1);
    	}
    }
}
