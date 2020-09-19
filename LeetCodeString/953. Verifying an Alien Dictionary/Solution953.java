import java.util.HashMap;
import java.util.Map;

public class Solution953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length <= 1) return true;
        Map<Character,Integer> dict = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            char c= order.charAt(i);
            dict.put(c, i);
        }
        
        for(int i = 1; i < words.length; i++) {
            String curr = words[i], prev = words[i-1];
            if(prev.startsWith(curr)) return false;
            char[] compareRes = findDiff(prev, curr);
            if(compareRes == null) continue;
            if(dict.get(compareRes[0]) > dict.get(compareRes[1])) {
                return false;
            }
        }
        return true;
    }
    
    public char[] findDiff(String s1, String s2) {
        char[] res = null;
        int index = 0;
        while(index < s1.length() && index < s2.length()) {
            char c1 = s1.charAt(index);
            char c2 = s2.charAt(index);
            if( c1 != c2 ) {
                res = new char[2];
                res[0] = c1;
                res[1] = c2;
                return res;
            }
            index++;
        }
        return res;
    }
}
