import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution269 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//The order could be decided only by character in string[i] and string[i+1];
	//Hence, check each compare to find first diff character to make sure the dependence relationship
	//Then, the dependence relationship will used to solve the solution by following topological ordering algorithm.
	//However, the final solution should be concerned whther the dependence result contains all characters.
    public String alienOrder(String[] words) {
		Map<Character, List<Character>> graph = new HashMap<>();
        boolean[] seen = new boolean[26];
        int[] inDegree = new int[26];
        if(words.length == 1) {
        	for(char c: words[0].toCharArray()) {
        		seen[c-'a'] = true;
        	}
        }
        for(int i = 0; i< words.length - 1; i++) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i+1].toCharArray();
            int len1 = word1.length;
            int len2 = word2.length;
            if(len1 > len2 && words[i].startsWith(words[i+1])) {
                return "";
            }
            boolean isContinue = true;
            for(int j = 0; j < Math.max(len1, len2); j++) {
                char a = '0';
                if (j < len1) {
                    a = word1[j];
                    seen[a - 'a'] = true;
                }
                char b = '0';
                if (j < len2) {
                    b = word2[j];
                    seen[b-'a'] = true;
                }
                if( j < len1 && j < len2 && a != b && isContinue) {
                    graph.putIfAbsent(a, new LinkedList<>());
                    graph.get(a).add(b);
                    inDegree[b - 'a']++;
                    isContinue = false;
                }
            }
        }
        
        int totalChars = 0;
        Deque<Character> que = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            if(seen[i]) {
                totalChars++;
                if(inDegree[i] == 0) {
                    que.offerLast((char)(i+'a'));
                }
            }
        }
        
        

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            char c = que.pollFirst();
            sb.append(c);
            if(graph.containsKey(c)){
                for(char next: graph.get(c)){
                    if(--inDegree[next-'a'] == 0) {
                        que.offerLast(next);
                    }
                }
            }
        }
        
        if(totalChars != sb.length()) {
            return "";
        } else {
            return sb.toString();
        }
    }
}
