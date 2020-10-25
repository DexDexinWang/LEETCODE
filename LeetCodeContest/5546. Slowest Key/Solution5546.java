
public class Solution5546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestTime = releaseTimes[0];
        char longestChar = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++) {
            int currentTime = releaseTimes[i] - releaseTimes[i-1]; 
            if(currentTime >= longestTime) {
                if(currentTime > longestTime || (currentTime == longestTime && keysPressed.charAt(i) >= longestChar)) {
                    longestChar = keysPressed.charAt(i);
                } 
                longestTime = currentTime;
            }
        }
        return longestChar;
    }
}
