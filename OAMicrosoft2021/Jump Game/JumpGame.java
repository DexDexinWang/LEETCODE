import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class JumpGame {

	/*
	 * 
You are given an array of non-negative integers arr and a start index. When you are at an index i, you can move left or right by arr[i]. Your task is to figure out if you can reach value 0.

Example 1:

Input: arr = [3, 4, 2, 3, 0, 3, 1, 2, 1], start = 7
Output: true
Explanation: left -> left -> right
	 * */
	public static void main(String[] args) {
		int[] nums = {3, 4, 2, 3, 0, 3, 1, 2, 1};
	    System.out.println(moveToZero(nums, 7));
        int arr[] = {3, 4, 2, 3, 0, 5, 1, 2, 1};
        System.out.println(moveToZero(arr, 7));
	}
	
	public static boolean moveToZero(int[] array, int start) {
		if(array == null || array.length == 0) {
			return false;
		}
		Deque<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		//int step = 0;
		queue.add(start);
		visited.add(start);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int position = queue.poll();
				int val = array[position];
				if(val == 0) {
					//System.out.println(step);
					return true;
				} else {
					int left = position - val; 
					if(left >= 0 && visited.add(left)) {
						queue.add(left);
					}
					int right = position + val;
					if(right < array.length && visited.add(right)) {
						queue.add(right);
					}
				}
			}
			//step++;
		}
		return false;
	}
	

}
