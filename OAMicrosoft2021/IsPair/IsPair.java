import java.util.HashSet;
import java.util.Set;

public class IsPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {1,1,2,1,2,2,1,2};
        System.out.println(pair(arr));
    }

	public static boolean pair(int[] array) {
		if(array == null || array.length == 0 || array.length % 2 == 1) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for(int num: array) {
			if(!set.add(num)) {
				set.remove(num);
			}
		}
		return set.size() == 0;
	}
}
