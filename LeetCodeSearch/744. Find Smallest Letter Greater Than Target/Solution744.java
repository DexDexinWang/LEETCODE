
public class Solution744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static char nextGreatestLetter(char[] letters, char target) {
        //corner cases
        int len = letters.length;
        if (target >= letters[len -1]) {
            return letters[0];
        } else if (target < letters[0]) {
            return letters[0];
        }
        
        int i = 0;
        int j = len -1;
        while (i < j -1) {
            int mid = i + (j - i) / 2;
            if (letters[mid] <= target) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return letters[j];
    }
}
