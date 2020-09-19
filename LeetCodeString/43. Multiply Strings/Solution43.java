import java.util.LinkedList;
import java.util.List;

public class Solution43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43 test = new Solution43();
		System.out.println(test.multiply("408", "5"));
	}
	
	public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int i = num1.length() - 1;
        List<String> res = new LinkedList<>();
        int offset = 0;
        while(i >= 0) {
            String temp = getSinlgeMultply(num1.charAt(i) - '0', num2, offset++); 
            res.add(temp);
            i--;
        }
        
        return sumAll(res);
    }
    
    private String sumAll(List<String> res) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        boolean flag =  true;
        int index = 0;
        while (flag) {
            flag = false;
            int sum  = 0;
            for(String str : res) {
                if(index < str.length()) {
                    sum+= str.charAt(index)- '0';
                    flag = true;
                }
            }
            if(carry != 0) {
            	flag = true;
            }
            sum += carry;
            if(sum == 0 && !flag) {
                return sb.reverse().toString();
            }else {
                sb.append(sum % 10);
                carry = sum / 10;
            }
            index++;
        } 
        return "";
    }
    
    private String getSinlgeMultply(int digit, String num, int offset) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for(int j = num.length() - 1; j>=0 ; j--) {
            int res = digit * (num.charAt(j) - '0') + carry;
            sb.append(res % 10);
            carry = res / 10;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        for(int i = 0; i < offset; i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    
    public String multiply2(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for(int i = num1.length()  - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p1] += sum / 10;
                result[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        
        for(int p : result) 
        {
            if(!(sb.length() == 0 && p == 0)) 
                sb.append(p);
        }
        
       return sb.length() == 0 ? "0" : sb.toString();
    }
}
