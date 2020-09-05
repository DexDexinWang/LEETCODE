
public class Solution137 {

	public static void main(String[] args) {
		System.out.println(new Solution137().singleNumber(new int[] {2,2,2,3}));
	}
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for(int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }
        return once;
    }
}
