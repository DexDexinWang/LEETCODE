import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Tier {
        Tier[] nextList;
        boolean isWord;
        public Tier() {
            nextList = new Tier[26];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Tier root = new Tier();
        for(String product: products) {
            Tier curr = root;
            for(int i = 0 ; i < product.length(); i++) {
                int index = product.charAt(i) - 'a';
                if(curr.nextList[index] == null) {
                    curr.nextList[index] = new Tier();
                }
                if(i == product.length() -  1) {
                    curr.nextList[index].isWord = true;
                } 
                curr = curr.nextList[index];
            }
        }
        List<List<String>> res = new LinkedList<>();
        Tier curr = root;
        char[] chars = searchWord.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
        	char c = chars[i];
            curr = curr.nextList[c-'a'];
            sb.append(c);
            List<String> tempRes = new LinkedList<>();
            traverseTierTree(curr, sb, tempRes);
            if(tempRes.size() > 3) {
            	Collections.sort(tempRes);
            	List<String> newRes = new LinkedList<>();
            	for(int j = 0; j < 3; j++) {
            		newRes.add(tempRes.get(j));
            	}
            	tempRes = newRes;
            } 
            res.add(tempRes);
        }
        return res;
    }
    
    public void traverseTierTree(Tier root, StringBuilder sb, List<String> res) {
        if(root == null) return;
        
        if(root.isWord) {
            res.add(sb.toString());
        }
        for(int i =0 ; i< 26; i++) {
            Tier next = root.nextList[i];
            sb.append((char)(i + 'a'));
            traverseTierTree(next, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    //Time complexity O(m characters for all words + 26*Max(product.length())^2)
    //Space time complexity O(m characters for all words);
    
    
    class Trie {
        List<String> word;
        Trie[] children;
        public Trie() {
            word = new ArrayList<>();
            children = new Trie[26];
        }
    }
    
    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        Trie root = new Trie();
        
        //build Trie
        for(String w: products) {
            Trie node = root;
            for(char c: w.toCharArray()) {
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new Trie();
                node = node.children[c-'a'];
                node.word.add(w);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        Trie dummy = root;
        
        for(int i = 0; i < searchWord.length(); i++)
            res.add(new ArrayList<>());
        
        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if(dummy != null && dummy.children[c-'a'] != null) {
                List<String> list = dummy.children[c-'a'].word;
                Collections.sort(list);
                for(int k = 0; k < Math.min(3, list.size()); k++)
                    res.get(i).add(list.get(k));
            }
            if(dummy != null)
                dummy = dummy.children[c-'a'];
        }
        
        return res;
    }
    //Time complexity O(m characters for all words); Space complexity: O(words^2);
}
