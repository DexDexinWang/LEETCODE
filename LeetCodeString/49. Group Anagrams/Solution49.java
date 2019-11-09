
import java.util.*;

public class Solution49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for(String s :strs) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) count[c-'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
