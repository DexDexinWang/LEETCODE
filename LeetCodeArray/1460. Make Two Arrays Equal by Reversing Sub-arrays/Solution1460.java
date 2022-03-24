
public class Solution1460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counter = new int[1001];
        for(int i: target) {
            counter[i]++;
        }
        for(int j: arr) {
            counter[j]--;
        }
        for(int i = 1; i < 1001; i++) {
            if(counter[i]!= 0) {
                return false;
            }
        }
        return true;
    }
}
