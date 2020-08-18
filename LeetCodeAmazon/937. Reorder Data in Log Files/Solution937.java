import java.util.Arrays;

public class Solution937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String a, String b)->{
            String[] log1 = a.split(" ",2);
            String[] log2 = b.split(" ",2);
            boolean isDigit1= Character.isDigit(log1[1].charAt(0));
            boolean isDigit2= Character.isDigit(log2[1].charAt(0));
            if(!isDigit1&& !isDigit2) {
                int temp = log1[1].compareTo(log2[1]);
                if(temp == 0) return log1[0].compareTo(log2[0]);
                return temp;
            } else {
                return isDigit1 && isDigit2 ? 0 : (!isDigit1 ? -1 : 1);
            }
        });
        return logs;
    }
}
