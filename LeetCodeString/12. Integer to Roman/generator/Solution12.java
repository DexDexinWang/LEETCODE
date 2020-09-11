package generator;

public class Solution12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
	String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
	        for(int i = 0 ; i < values.length; i++) {
	          while(values[i] <= num) {
	            sb.append(symbols[i]);
	            num-= values[i];
	          }
	        }
	      return sb.toString();
    }
}