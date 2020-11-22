import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution5603 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5603 test = new Solution5603();
		System.out.println(test.closeStrings("cabbba", "abbccc"));
		System.out.println(test.closeStrings("cabbba", "aabbss"));
		System.out.println(test.closeStrings("uau", "ssx"));
	}
	
	
	public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
      
        
        Map<Integer,Integer> map1 = getCounterMap(word1, len1, set1); 
        Map<Integer,Integer> map2 = getCounterMap(word2, len2, set2);
        
        if(!set1.equals(set2)) return false; 
        
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(!map2.containsKey(key) || map2.get(key)!= value) {
                return false;
            }
        }
        return true;
    }
	
    
    public Map<Integer,Integer> getCounterMap(String word1, int len, Set<Character> set) {
        int[] count = new int[26];
        for(char c: word1.toCharArray()) {
            count[c-'a']++;
            set.add(c);
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                map.put(count[i], map.getOrDefault(count[i], 0) + 1);
            }
        }
        return map;
    }
}
