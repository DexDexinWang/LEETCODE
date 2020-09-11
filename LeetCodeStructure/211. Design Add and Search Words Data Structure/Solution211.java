
class WordDictionary {

	class Trie {
		boolean isWord = false;
		Trie[] next = new Trie[26];
	}

	/** Initialize your data structure here. */
	Trie root = null;

	public WordDictionary() {
		root = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Trie curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.next[c - 'a'] == null) {
				curr.next[c - 'a'] = new Trie();
			}
			curr = curr.next[c - 'a'];
		}
		curr.isWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return dfsSearch(root, word.toCharArray(), 0);
	}

	public boolean dfsSearch(Trie curr, char[] chars, int index) {
		if (curr == null) { // null
			return false;
		}
		char temp = chars[index];
		if (index == chars.length - 1) {// last index
			if(temp == '.') {
				for(Trie t: curr.next) {
					if(t == null) continue;
					if(t.isWord) return true;
				}
				return false;
			} else {
				return  curr.next[temp - 'a'] != null && curr.next[temp - 'a'].isWord;
			}
			
		}
		if (temp == '.') {
			for (Trie n : curr.next) {
				boolean res = dfsSearch(n, chars, index + 1);
				if (res) {
					return true;
				}
			}
			return false;
		} else {
			if (curr.next[temp - 'a'] != null) {
				return dfsSearch(curr.next[temp - 'a'], chars, index + 1);
			} else {
				return false;
			}
		}
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */

public class Solution211 {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b.."));
	}

}
