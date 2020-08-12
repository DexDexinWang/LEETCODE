import java.util.Deque;
import java.util.LinkedList;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int generalizeGCD(int num, int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		Deque<Integer> que = new LinkedList<>();
		for(int i =0; i < arr.length; i++) {
			que.offerLast(arr[i]);
		}
		while(que.size() >= 2) {
			que.offerLast(GCD(que.pollFirst(), que.pollFirst()));
		}
		return que.pollFirst();
	}
	
	public int GCD(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		}
		return GCD(num2, num1 % num2);
	}
}
