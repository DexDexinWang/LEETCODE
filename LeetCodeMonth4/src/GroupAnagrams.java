import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams test = new GroupAnagrams();
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		test.groupAnagrams(strs);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String,List<String>> counters = new HashMap<>();
        for(String str : strs) {
            int[] counter = new int[26];
            for(Character c: str.toCharArray()) {
                counter[c-'a']++;
            }
            String key = convertArrayToString(counter);
            if (counters.containsKey(key)) {
            	counters.get(key).add(str);
            } else {
            	List<String> temp = new LinkedList<>();
            	temp.add(str);
            	counters.put(key, temp);
            }
        }
        List<List<String>> res= new LinkedList<>();
        for(Map.Entry<String,List<String>> entry: counters.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
        
    }
    
    public String convertArrayToString(int[] counter) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if (counter[i]!= 0) {
                sb.append((char)(i+'a')).append(counter[i]);
            }
        }
        return sb.toString();
    }
    
    //Time compelxity: O(n * m) where n is the length of array. m is the maximum length of each characters.
    //Space compelxity: O(n * m) where n is the length of array. m is the maximum length of each characters.
}
