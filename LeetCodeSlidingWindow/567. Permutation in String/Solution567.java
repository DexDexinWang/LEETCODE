import java.util.HashMap;
import java.util.Map;

public class Solution567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count = new HashMap<>();
        for(char s : s1.toCharArray()) {
            count.put(s,count.getOrDefault(s, 0) + 1);
        }
        int len = s1.length();
        int totalMatched = 0;
        int left = 0;
        int right = 0;
        while(right < s2.length()) {
            char curr = s2.charAt(right);
            if(count.containsKey(curr)) {
                count.put(curr, count.get(curr) - 1);
                if(count.get(curr) == 0) totalMatched++;
            }
            while(right - left + 1 > len) {
                char delete = s2.charAt(left++);
                if(count.containsKey(delete)) {
                    count.put(delete, count.get(delete) + 1);
                    if(count.get(delete) == 1) totalMatched--;
                }
            }
            if (totalMatched == count.size()) return true;
            right++;
        }
        return false;
    }
}
