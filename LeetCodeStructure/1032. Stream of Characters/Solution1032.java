import java.util.LinkedList;
import java.util.List;

class StreamChecker {

    class Trie{
        boolean isWord = false;
        Trie[] next = new Trie[26];
    }
    
    public Trie root;
    public List<Character> list;
    public int k = 0;
    public StreamChecker(String[] words) {
        root = new Trie();
        list = new LinkedList<>();
        for(String word: words) {
            Trie curr = root;
            k = Math.max(k, word.length());
            for(int i = word.length() - 1; i >= 0 ; i--) {
                char c = word.charAt(i);
                if(curr.next[c- 'a'] == null) {
                    curr.next[c-'a'] = new Trie();
                }
                curr = curr.next[c-'a'];
            }
            curr.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        if(list.size() > k) {
            list.remove(0);
          }
        list.add(letter);
        Trie curr = root;
        int index = list.size() - 1;
        while(index >= 0 && list.size() - 1 - index + 1 <= k ) {
            char c = list.get(index);
            if(curr.next[c-'a'] == null) return false;
            curr = curr.next[c - 'a'];
            if(curr.isWord) return true;
            index --;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
public class Solution1032 {

	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] {"cd","f","kl"});
		streamChecker.query('a');          // return false
		streamChecker.query('b');          // return false
		streamChecker.query('c');          // return false
		streamChecker.query('d');          // return true, because 'cd' is in the wordlist
		streamChecker.query('e');          // return false
		streamChecker.query('f');          // return true, because 'f' is in the wordlist
		streamChecker.query('g');          // return false
		streamChecker.query('h');          // return false
		streamChecker.query('i');          // return false
		streamChecker.query('j');          // return false
		streamChecker.query('k');          // return false
		streamChecker.query('l');          // return true, because 'kl' is in the wordlist
	}

}
