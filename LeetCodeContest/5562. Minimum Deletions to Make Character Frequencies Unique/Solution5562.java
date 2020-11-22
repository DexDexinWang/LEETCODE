import java.util.HashSet;
import java.util.Set;

public class Solution5562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5562().minDeletions("ceabaacb"));
	}
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        int total = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <26; i++) {
            int temp = count[i];
            if(temp == 0) continue;
            if(!set.add(temp)) {
                for(int j = temp - 1; j >= 0; j--) {
                    if(j == 0) {
                    	total += temp;
                    	break;
                    }
                    if(set.add(j)) {
                        total+= temp - j;
                        break;
                    }
                }
            } 
        }
        return total;
    }
}
