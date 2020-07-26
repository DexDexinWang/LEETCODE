import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1153().canConvert("aabcc", "ccdee"));
	}
    public boolean canConvert(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        if(str1.equals(str2)) return true;
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i =0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.getOrDefault(c1, c2) != c2) return false;
            map.put(c1, c2);
            set.add(c2);
        }
        return !(map.size() == 26 && set.size() == 26);
    }
}
