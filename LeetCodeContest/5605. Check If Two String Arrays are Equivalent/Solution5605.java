
public class Solution5605 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5605 test = new Solution5605();
		System.out.println(test.arrayStringsAreEqual(new String[] {"ab","c"},new String[] {"a","bc"}));
	}
	
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int x = 0, y = 0; 
        int i = 0, j = 0;
        while(x < word1.length && y < word2.length) {
            if(word1[x].charAt(i) == word2[y].charAt(j)) {
                i++;
                if(i == word1[x].length()) {
                    i = 0;
                    x++;
                }
                j++;
                if(j == word2[y].length()) {
                    j = 0;
                    y++;
                }
            } else {
                return false;
            }
        }
        if(x < word1.length && i < word1[x].length()) {
            return false;
        }
        if(y < word2.length && j < word1[y].length()) {
            return false;
        }
        return true;
    }
}
