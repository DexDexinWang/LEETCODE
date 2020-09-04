
public class Solution318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] masks = new int[len];
        for(int i = 0; i < len; i++) {
            int mask = 0;
            for(char c : words[i].toCharArray()) {
                mask |= 1<< (c - 'a');
            }
            masks[i] = mask;
        }
        int max = 0;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 1; j < len ; j++) {
                if((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
