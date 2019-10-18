import java.util.Arrays;

public class Solution937 {

	public static void main(String[] args) {
		Solution937 test = new Solution937();
		String[] input = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		System.out.println(Arrays.deepToString(test.reorderLogFiles(input)));
	}

	public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
        	String[] let1 = log1.split(" ", 2);
        	String[] let2 = log2.split(" ", 2);
        	boolean isDigit1 = Character.isDigit(let1[1].charAt(0));
        	boolean isDigit2 = Character.isDigit(let2[1].charAt(0));
        	if (!isDigit1 && !isDigit2) {
        		int temp = let1[1].compareTo(let2[1]);
        		if (temp != 0) {
        			return temp;
        		}else {
        			return let1[0].compareTo(let2[0]);
        		}
        	} else {
        		return isDigit1 ? (isDigit2 ? 0 : 1):  -1;
        	}
        });
        return logs;
	}
	//Time complexity O(nlogn) 
	//Space complexity O(n)
}
