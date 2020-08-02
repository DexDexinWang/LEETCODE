
public class Solution5476 {

    public int getWinner(int[] arr, int k) {
        int len = arr.length;
        int count = 0;
        int res = arr[0];
        for(int j = 1; j < len; j++) {
            if(res > arr[j]) {
                count++;
            } else {
                res = arr[j];
                count = 1;
            }
            if (count == k) return res;
        }
        return res;
    }
}
