import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Solution350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		//check corner cases
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        //sort algorithm;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0; 
        int j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else {
                //move smaller one.
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
	//Time complexity:O(nlogn) 
	//Space complexity: O(n);
	
	public static int[] intersect2(int[] nums1, int[] nums2) {
		//check corner cases
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums2) {
        	if (map.containsKey(num) && map.get(num) > 0) {
        		result.add(num);
        		map.put(num, map.get(num) - 1);
        	}
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
	//Time complexity: O(max(n,m));
	//Space complexity: O(max(n,m));
	
}
