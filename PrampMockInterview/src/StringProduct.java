import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringProduct {

	  void reverse(int[] x)
	  {
	    int left = 0;
	    int right = x.length -1;
	    while(left < right)
	    {
	      int t = x[left];
	      x[left] = x[right];
	      x[right] = t;
	      left++;
	      right--;
	    }
	  }
	  
	 public boolean getSign(int[] num1, int[] num2){
	   boolean res =  num1[0] * num2[0] > 0;
	   num1[0] = Math.abs(num1[0]);
	   num2[0] = Math.abs(num2[0]);
	   return res;
	 }
	 public String product(int[] num1, int[] num2) 
	 {
	   boolean sign = getSign(num1, num2); //-1223345, -122345
	   reverse(num1);
	   reverse(num2);
	   
	    List<Integer>[] dp = new LinkedList[num2.length];
	    
	    /*
	         1 2 3 4
	             3 4
	    -----------------------  
	      4  9  3  6           
	   3  7  0  2  0
	   */
	    for(int row = 0; row < num2.length; row++) {
	      dp[row] = new LinkedList<>();
	      for(int i = 0; i < row; i++) {
	        dp[row].add(i,0);
	      }
	      int offset = 0;
	      for(int col = 0; col < num1.length; col++) {
	        int num = num1[col] * num2[row] + offset;
	        offset = num / 10;
	        int remin = num % 10;
	        dp[row].add(col+row, remin);
	      }
	    }
	   
	   /*
	         4  9  3  6           
	      3  7  0  2  0
	   ----------------
	   4  1   9   5   6
	   */
	    List<Integer> temp = new LinkedList<>();
	    int maxLen = dp[dp.length -1].size();
	    int offset = 0;
	    for(int i = 0; i < maxLen; i++) {  
	      int sum = 0;
	      for(int j =0; j < dp.length; j++) {
	        sum+= dp[j].size() > i ? dp[j].get(i):0;
	      }
	      temp.add((sum + offset) % 10);
	      offset = sum / 10;
	    }
	    while(offset!= 0) {
	      temp.add(offset % 10);
	      offset = offset / 10;
	    }
	    
	    StringBuilder sb = new StringBuilder(); 
	    boolean isLeadingZero = true;
	    for(int i = temp.size() - 1; i>=0; i--) {
	      if(temp.get(i) == 0 && isLeadingZero) {
	        continue;
	      }
	      else {
	        isLeadingZero = false;
	      }
	      sb.append(temp.get(i));
	    }
	   return sb.length() == 0 ? "0" : (sign? "": "-") + sb.toString();
	 }
	  //Time complexity: O(n*m)  Space(n*m);
	  
	  public static void main(String[] args) {

	    String s = "93409345890345890349034890345905675675675675765758345890348903458909034534535434569045690456689054";
	    int[] input = new int[s.length()];
	    for(int i = 0; i < s.length();i++) {
	      input[i] = s.charAt(i) - '0';
	    }
	    System.out.println(Arrays.toString(input));
	    System.out.println(new StringProduct().product(input, new int[]{-1, 0,0}));// 185803
	  }

}
