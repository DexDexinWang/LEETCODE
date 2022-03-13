import java.util.HashSet;
import java.util.Set;

public class Solution1647 {

    // In my personal opinion, I prefer to solve the issue by count frequency for all characters in the string. 
    // Then, I will chack frequency from hight to low. 
    // Next, I will reduce the frequency by one if there are two charcters has the same frequency.
    // E.g. A = 26, B = 25, c = 26
    // Set<> saves frequency, int sum record the total deleted characters.
    // Set[]  A =26  ==> Set[A = 26];
    // Set[A = 26] B = 25 ==> Set[A = 26, B = 25]
    // Set[a = 26, B = 25] C = 26 ==>  Set[a = 26, B = 25] C = 25  sum = 1;
    // Set[a = 26, B = 25] C = 25 ==>  Set[a = 26, B = 25] C = 24  sum = 2;
    // Hence, the time complexity will be O(n) + O(m) where n is the lenght of S, and m is the number of different characters. 
    public int minDeletions(String s) {
        // corner case
        if(s == null || s.length() <= 1) {
            return 0;
        }
        int[] counter = new int[26];
        for(char c: s.toCharArray()) {
            counter[c-'a']++;
        }
        
        Set<Integer> frequencySet = new HashSet<>();
        int sum = 0;
        int i = 0;
        while(i < 26) {
            int frequency = counter[i];
            while(frequencySet.contains(frequency) && frequency != 0) {
                frequency--;
                sum++;
            }
            frequencySet.add(frequency);
            i++;
        }
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
