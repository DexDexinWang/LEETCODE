import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"});
	}
	
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(String str : banned) bannedSet.add(str);
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        Map<String,Integer> count = new HashMap<>();
        for(String word: words) {
            if(bannedSet.contains(word)) continue;
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
