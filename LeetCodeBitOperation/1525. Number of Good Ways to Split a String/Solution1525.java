
public class Solution1525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1525().numSplits("aacaba"));
	}
	
    public int numSplits(String s) {
        int res = 0;
        int[] lr = new int[26];
        int[] rl = new int[26];
        int lTotal = 0;
        int rTotal = 0;
        for(char c : s.toCharArray()) {
            if(rl[c-'a']++ == 0) {
               rTotal++; 
            }
        }
        for(char c : s.toCharArray()) {
            if(lr[c-'a']++ == 0) {
                lTotal++;
            }
            if(--rl[c-'a'] == 0) {
                rTotal--;
            }
            res += lTotal == rTotal? 1 : 0;
        }
        return res;
    }
	
    public int numSplits1(String s) {
        int total = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int temp1 = 0;
            int left = 0;
            while(left <= i) {
                temp1 |= 1 << (s.charAt(left++) - 'a');
            }
            int temp2 = 0;
            int right = i+1; 
            while(right < s.length()) {
                temp2 |= 1 << (s.charAt(right++) - 'a');
            }
            if(countOnes(temp1) == countOnes(temp2)) {
                total++;
            }
        }
        return total;
    }
    
    public int countOnes(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n&=(n-1);
        }
        return res;
    }
}
