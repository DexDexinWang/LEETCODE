
public class HappyNumber {

	  public static boolean find(int num) {
		    int slow = num;
		    int fast = num;
		    do {
		      slow = findHappyNum(slow);
		      fast = findHappyNum(findHappyNum(fast));
		    }while(slow != fast);
		    
		    return slow == 1;
		  }

		  public static int findHappyNum(int num) {
		    int res = 0;
		    while(num != 0) {
		      int temp = num % 10;
		      res += temp * temp;
		      num /= 10;
		    } 
		    return res;
		  } 

		  public static void main(String[] args) {
		    System.out.println(HappyNumber.find(23));
		    System.out.println(HappyNumber.find(12));
		  }

}
