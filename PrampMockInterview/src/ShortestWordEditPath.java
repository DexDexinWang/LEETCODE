import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestWordEditPath {
/*
Given two words source and target, and a list of words words, find the length of the shortest series of edits that transforms source to target.

Each edit must change exactly one letter at a time, and each intermediate word (and the final target word) must exist in words.

If the task is impossible, return -1.

Examples:

source = "bit", target = "dog"
words = ["but", "put", "big", "pot", "pog", "dog", "lot"]

output: 5
explanation: bit -> but -> put -> pot -> pog -> dog has 5 transitions.
source = "no", target = "go"
words = ["to"]

output: -1
Constraints:

[time limit] 5000ms
[input] string source
1 ¡Ü source.length ¡Ü 20
[input] string target
1 ¡Ü target.length ¡Ü 20
[input] array.string words
1 ¡Ü words.length ¡Ü 20
[output] array.integer
 * */
	  //DFS
	  //how many levels: words.length;
	  //how many statu in each level: words.length;
	  static int ans;
	  static boolean[] visited;
	  static String[] words1;
	  static String target1;
	  static int shortestWordEditPathDFS(String source, String target, String[] words) {
		ans = Integer.MAX_VALUE;
	    visited = new boolean[words.length];
	    words1 = words;
	    target1 = target;
	    dfs(source, 0);
	    return ans == Integer.MAX_VALUE ? -1: ans;
	}
	  
	  static void dfs(String curr, int height) {
	    if (curr.equals(target1)){
	      ans=Math.min(height, ans);
	      return;
	    }
	    for(int i = 0; i < words1.length; i++) {
	      if(visited[i] || !check(curr, words1[i])) continue;
	      visited[i] = true;
	      dfs(words1[i], height+1);
	      visited[i] = false;
	    }
	  }
	  
	  static boolean check(String s1 , String s2) {
	    char[] c1 = s1.toCharArray();
	    char[] c2 = s2.toCharArray();
	    if(c1.length == 0 || c1.length != c2.length) return false;
	    int count= 0;
	    for(int i = 0; i < c1.length; i++) {
	      count += c1[i] == c2[i] ? 1 :0;
	    }
	    return count == c1.length -1;
	  }

		public static void main(String[] args) {
			 
			System.out.println(shortestWordEditPathDFS("bit", "dog", new String[] {"but","put","big","pot","pog","dog","lot"}));
			System.out.println(shortestWordEditPath("bit", "dog", new String[] {"but","put","big","pot","pog","dog","lot"}));
		}
		
	
			 
			  static int shortestWordEditPath(String source, String target, String[] words) {
		      if(source == target) return 0;
				  Deque<Word> que = new LinkedList<>();
		      que.offer(new Word(source, 0));
		      Set<String> seen = new HashSet<>();
		      while(!que.isEmpty()) {
		        Word curr = que.pollFirst();
		        if(curr.word == target) return curr.len;
		        for(int i = 0; i < words.length; i++) {
		          String next = words[i];
		          if(seen.contains(next)|| !check(next,curr.word)) continue;
		          seen.add(next);
		          que.offerLast(new Word(next, curr.len + 1));
		        }
		      }
		      return -1;
			}
		
		
}

class  Word{
    String word;
    int len;
    public Word(String word, int len){
      this.word = word;
      this.len = len;
    }
  }
