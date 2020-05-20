import java.util.HashSet;
import java.util.Set;

public class CountingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int countElements(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i-1);
        }
        int counter = 0;
        for(int i : arr) {
            if (set.contains(i)) {
                counter++;
            }
        }
        return counter;
    }

}
