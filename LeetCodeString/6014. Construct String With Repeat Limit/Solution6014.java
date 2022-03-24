
public class Solution6014 {

	public static void main(String[] args) {
		Solution6014 s = new Solution6014();
		System.out.println(s.repeatLimitedString("cczazcc", 3));

	}
	
	
	public String repeatLimitedString(String s, int repeatLimit) {
        int[] counter = new int[26];
        populateCounter(counter, s.toCharArray());
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < len) {
            if(!validateCounter(counter, sb)) break;
            boolean isPreviousZero = true;
            for(int i = 25 ; i >= 0; i--) {
                if(counter[i] != 0) {
                    int maxLen = isPreviousZero ? Math.min(counter[i], repeatLimit) : 1;
                    for(int j = maxLen; j > 0; j--) {
                        sb.append((char)('a' + i));
                    }
                    counter[i] -= maxLen;
                    isPreviousZero = counter[i] == 0;
                }
            }
        }
        return sb.toString();
    }
    
    private void populateCounter(int[] counter, char[] array) {
        for(int i = 0; i < array.length; i++) {
            counter[array[i] - 'a']++;
        }
    }
    
    private boolean validateCounter(int[] counter, StringBuilder sb) {
        int sum = 0;
        for(int i = 0; i < 26; i++) {
            if(counter[i] != 0) {
                sum++;
            }
        }
        if(sum == 0) {
            return false;
        } else if (sum == 1) {
        	if(sb.length() == 0) return true;
            return counter[sb.charAt(sb.length() - 1) - 'a'] == 0;
        } else {
            return true;
        }
    }

}
