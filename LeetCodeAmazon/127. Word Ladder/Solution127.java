import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution127().ladderLength1("hit", "cog", Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"})));
	}
	
	//BFS check words within levels
    //Initial Status (the node to be expended):  beginWord
    //Generation Rule: if there is a word in wordList that has the same length with beginword and only one different character
    //Termination rule: no more word could be expended  or find the target
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || wordList == null || wordList.size() == 0) return 0;
        Set<String> seen = new HashSet<>();
        Deque<String> que = new LinkedList<>();
        que.offerLast(beginWord);
        seen.add(beginWord);
        int step = 1;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size ; i++) {
                String curr = que.pollFirst();
                if(curr.equals(endWord)) return step;
                for(String word: wordList) {
                    if(!seen.contains(word) &&checkStrings(word, curr)) {
                        que.offerLast(word);
                        seen.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }
    
    public boolean checkStrings(String a, String b) {
        if(a.length() != b.length()) return false;
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            count+= a.charAt(i) != b.charAt(i) ? 1 : 0;
        }
        return count == 1;
    }
    
    
  //BFS check words within levels
    //Initial Status (the node to be expended):  beginWord
    //Generation Rule: if there is a word in wordList that has the same length with beginword and only one different character
    //Termination rule: no more word could be expended  or find the target
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || wordList == null || wordList.size() == 0) return 0;
        Set<String> seen = new HashSet<>();
        Deque<String> que = new LinkedList<>();
        que.offerLast(beginWord);
        seen.add(beginWord);
        int step = 1;
        Set<String> words = new HashSet<>();
        for(String word : wordList) words.add(word);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size ; i++) {
                String curr = que.pollFirst();
                if(curr.equals(endWord)) return step;
                for(int j = 0; j < curr.length(); j++) {
                	String temp = curr.substring(0,j) + "*" + curr.substring(j+1); 
                	char[] chars= "abcdefghijklmnopqrstuvwxyz".toCharArray();
                	for(int k = 0; k < 26; k++) {
                		String newTemp = temp.replace('*', chars[k]);
                		if(words.contains(newTemp) && !seen.contains(newTemp)) {
                			que.offerLast(newTemp);
                			seen.add(newTemp);
                		}
                	}
                }
            }
            step++;
        }
        return 0;
    }
    

}
