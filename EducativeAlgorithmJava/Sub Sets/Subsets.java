import java.util.*;

class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		dfsFindSubSets(nums, 0, subsets, new LinkedList<>());
		return subsets;
	}

	public static void dfsFindSubSets(int[] nums, int index, List<List<Integer>> subsets, List<Integer> list) {
		if (index == nums.length) {
			subsets.add(new LinkedList<>(list));
			return;
		}
		dfsFindSubSets(nums, index + 1, subsets, list);
		list.add(nums[index]);
		dfsFindSubSets(nums, index + 1, subsets, list);
		list.remove(list.size() - 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = Subsets.findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

	public static List<List<Integer>> findSubsets1(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		// start by adding the empty subset
		subsets.add(new ArrayList<>());
		for (int currentNumber : nums) {
			// we will take all existing subsets and insert the current number in them to
			// create new subsets
			int n = subsets.size();
			for (int i = 0; i < n; i++) {
				// create a new subset from the existing subset and insert the current element
				// to it
				List<Integer> set = new ArrayList<>(subsets.get(i));
				set.add(currentNumber);
				subsets.add(set);
			}
		}
		return subsets;
	}
}
