import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalUtilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a1 = {{1, 2}, {2, 4}, {3, 6}};
		int[][]	b1 = {{1, 2}};
		int	target1 = 7;
		for(List<Integer> ele : getOptimalUtilization(a1, b1, target1)) {
			System.out.println(ele.toString());
		}
		System.out.println("----------------------------");
		int[][] a2 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target2 = 10;
		for(List<Integer> ele : getOptimalUtilization(a2, b2, target2)) {
			System.out.println(ele.toString());
		}
		System.out.println("----------------------------");
		int[][] a3 =  {{1, 5}, {2, 5}};
		int[][] b3 =  {{1, 5}, {2, 5}};
		int target3 = 10;
		for(List<Integer> ele : getOptimalUtilization(a3, b3, target3)) {
			System.out.println(ele.toString());
		}
	}
	
	public List<List<Integer>> aircraftUtilization(int target, int[][] a, int[][] b){
	    List<List<Integer>> res = new ArrayList<>();
	    int len1 = a.length;
	    int len2 = b.length;
	    if (len1 == 0 || len2 == 0) {
	    	return res;
	    }
	    Map<Integer, List<List<Integer>>> map = new HashMap<>();
	    int i = 0;
	    int j = len2 - 1;
	    int maxVal = -1;
	    while (i > len1 && j >=0) {
	    	int sum = a[i][1] + b[j][1];
	    	if (sum > target) {
	    		j--;
	    	} else {
	    		int leftOfright = j; 
	    		map.putIfAbsent(sum, new ArrayList<List<Integer>>());
	    		while (leftOfright >= 0 && b[leftOfright][1] == b[j][1]) {
	    			List<Integer> temp = Arrays.asList(i, leftOfright);
	    			map.get(sum).add(temp);
	    			leftOfright --;
	    		}
	    		maxVal = sum;
	    	}
	    	i++;
	    }
	    return map.get(maxVal);
	}
	
	public static List<List<Integer>> getOptimalUtilization(int[][] a, int[][] b, int target) {
		List<List<Integer>> res= new ArrayList<>();
		int len1 = a.length;
		int len2 = b.length;
		if (len1 == 0 || len2 == 0) {
			return res;
		}
		Arrays.parallelSort(a, (int[] x, int[] y) -> (x[1] - y[1]));
		Arrays.parallelSort(b, (int[] x, int[] y) -> (x[1] - y[1]));
		int left = 0; 
		int right = len2 - 1;
		int maxVal = -1;
		HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
		while (left < len1 && right >=0) {
			int sum = a[left][1] + b[right][1];
			if (sum > target) {
				right --; continue;
			}
			if (sum >= maxVal) {
				int r = right;
				map.putIfAbsent(sum, new ArrayList<>());
				while (r >= 0 && a[r][1] == b[right][1]) {
					List<Integer> list = new ArrayList<>();
					list.add(a[left][0]);
					list.add(b[r][0]);
					map.get(sum).add(list);
					r--;
				}
				maxVal = sum;
			}
			left++;
		}
		return map.get(maxVal);
	}
	//Time complexity O(n^2) 
	//space complexity O(n^2)

}
