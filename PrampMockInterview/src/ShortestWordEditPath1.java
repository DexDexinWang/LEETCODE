import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestWordEditPath1 {

static int shortestWordEditPath(String source, String target, String[] words) {
	if(source.equals(target)) {
      return -1;
    }
    Set<String> visited = new HashSet<>();
    Deque<String> queue = new LinkedList<>();
    queue.offer(source);
    int res = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        String tempSource = queue.poll();
        if(tempSource.equals(target)) {
          return res;
        }
        for(int j = 0; j < words.length; j++) {
          String tempTarget = words[j];
          if(findDifferentCharacter(tempSource, tempTarget)) {
            if (visited.add(tempTarget)) {
              queue.offer(tempTarget);
            }
          }
        }
      }
      res++;
    }
    return -1; 
	}
  
  static boolean findDifferentCharacter(String source, String target) {
    if(source.length() != target.length()) {
      return false;
    }
    char[] chars1 = source.toCharArray();
    char[] chars2 = target.toCharArray();
    boolean findDiff = false;
    for(int i = 0; i < chars1.length; i ++) {
      if(chars1[i] != chars2[i]) {
        if(findDiff) {
          return false;
        } else {
          findDiff = !findDiff;
        }
      }
    }
    return findDiff;
  }

	public static void main(String[] args) {
	  String[] words = new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"};
    System.out.println(ShortestWordEditPath1.shortestWordEditPath("bit","dog",words));
	}
}
