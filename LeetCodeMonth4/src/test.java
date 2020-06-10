import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private int[] numbers = new int[] {1,2,3,4,5,6,1,2,3};
	private int len = 9;
	public List<List<Integer>> paritionByUnique() {
		List<List<Integer>> res = new LinkedList<>();
		
		return res;
	}
	
	private int getNumberOfUniqueInteger(int start, int end) {
		Set<Integer> set = new HashSet<Integer>();
		while(start<=end) {
			set.add(numbers[start++]);
		}
		return set.size();
	}

}
