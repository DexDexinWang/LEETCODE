import java.util.Arrays;

public class Solution621 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int t: tasks) {
            count[t-'A']++;
        }
        Arrays.sort(count);
        
        int max = count[25];
        int idles = (max - 1) * n;
        
        for(int i = count.length - 2; i >= 0 && idles > 0; i--) {
            idles -= Math.min(max -1, count[i]);
        }
        idles = Math.max(0, idles);
        return idles + tasks.length;
    }
}
