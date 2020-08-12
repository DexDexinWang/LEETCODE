import java.util.LinkedList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = new int[] {1,0,0,0,0,1,0,0};
		int[] test2 = new int[] {1,1,1,0,1,1,1,1};
		System.out.println(new Demo1().cellCompete(test1, 1));
		System.out.println(new Demo1().cellCompete(test2, 1));
	}
	public List<Integer> cellCompete(int[] states, int days) {
		int len = states.length;
		for(int i = 0; i < days; i++) {
			int[] temp = new int[len];
			temp[0] = states[1] ^ 0;
			temp[len - 1] = states[len - 2] ^ 0;
			for(int j = 1; j < len - 1; j++) {
				temp[j] = states[j - 1] ^ states[j+1];
			}
			states = temp;
		}
		List<Integer> res = new LinkedList<>();
		for(int i = 0; i < len; i ++) {
			res.add(states[i]);
		}
		return res;
	}
}
