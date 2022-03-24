
public class Solution5629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5629 test = new Solution5629();
		System.out.println(test.reformatNumber(new String("1-23-45 6")));
	}

    public String reformatNumber(String number) {
        String polishedNumber = number.replace(" ", "").replace("-","");
        StringBuilder sb = new StringBuilder();
        int end = polishedNumber.length() - 1;
        int start = 0;
        while(end - start + 1 > 4) {
            for(int i= 0; i < 3; i++) {
                sb.append(polishedNumber.charAt(start++));
            }
            sb.append("-");
        }
        
        if(end - start + 1 == 4) {
            sb.append(polishedNumber.charAt(start++));
            sb.append(polishedNumber.charAt(start++));
            sb.append("-");
        }
        for(int i = start; i <= end; i++) {
            sb.append(polishedNumber.charAt(start++));
        }
        return sb.toString();
    }
}
