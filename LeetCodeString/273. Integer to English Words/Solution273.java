
public class Solution273 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    private final String[] symbols2 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred","Eight Hundred","Nine Hundred"};
	private final int[] values2 = {1, 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,
	                              200,300,400,500,600,700,800,900};
	private final String[] symbols1 = {"Thousand", "Million", "Billion"};
	private final int[] values1 = {1000, 1000000, 1000000000};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
	          StringBuilder sb = new StringBuilder();
	          for(int i = values1.length - 1; i >= 0; i--) {
	            if(values1[i] <= num) {
	              int temp = num / values1[i];
	              FindStirngSmallerThan1000(temp, sb);
	              num -= temp * values1[i];
	              sb.append(symbols1[i]).append(" ");
	            }
	          }
	          FindStirngSmallerThan1000(num, sb);
            sb.deleteCharAt(sb.length() - 1);
	        return sb.toString();
	  }
    public void FindStirngSmallerThan1000(int num, StringBuilder sb) {
	      for(int i = values2.length - 1; i >= 0; i--) {
	          while(values2[i] <= num) {
	            sb.append(symbols2[i]).append(" ");
	            num-= values2[i];
	          }
	      }
	  }
}
