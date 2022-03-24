
public class Solution5637 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution5637().halvesAreAlike("book");
	}

    public boolean halvesAreAlike(String s) {
        int count= 0;
        int halfCount = 0;
        int index = 0; 
        for(char c : s.toCharArray()) {
            count+= isVowel(c) ? 1 : 0;
            if(index == (s.length() - 1)/ 2) {
                halfCount = count;
            }
            index++;
        }
        return halfCount * 2 == count;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
