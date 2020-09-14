import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution969 {

	public static void main(String[] args) {
		System.out.print(new Solution969().pancakeSort(new int[] {1,2,3}));
	}
    public List<Integer> pancakeSort(int[] arr) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->(b-a));
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            max.offer(arr[i]);
        }
        for(int i = arr.length - 1; i>=0; i--) {
            if(arr[i] == max.peek()) {
                max.poll();
                continue;
            }
            int targetIndex = -1;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == max.peek()) {
                    targetIndex = j;
                    max.poll();
                    break;
                }
            }
            swap(arr, targetIndex);
            res.add(targetIndex+1);
            swap(arr, i);
            res.add(i+1);
        }
        return res;
    }
    
    public void swap(int[] arr, int right) {
        int left = 0;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
}
