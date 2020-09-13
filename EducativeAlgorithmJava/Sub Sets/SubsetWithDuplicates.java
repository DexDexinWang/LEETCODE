import java.util.*;

class SubsetWithDuplicates {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subSets = new ArrayList<>();
		Arrays.sort(nums);
		subSets.add(new LinkedList<>());
		int left = 0, right = 0;
		for (int i = 0; i < nums.length; i++) {
			left = 0;
			if (i != 0 && nums[i - 1] == nums[i]) {
				left = right + 1;
			}
			right = subSets.size() - 1;
			for (int j = left; j <= right; j++) {
				List<Integer> newSet = new LinkedList<>(subSets.get(j));
				newSet.add(nums[i]);
				subSets.add(newSet);
			}
		}
		return subSets;
	}

	public static int findSubsets1(int[] nums) {
		Arrays.sort(nums);

		int left = 0, right = 0, total = 1;

		for (int i = 0; i < nums.length; i++) {
			left = 0;

			if (i != 0 && nums[i - 1] == nums[i]) {
				left = right + 1;
			}

			right = total - 1;

			total += right - left + 1;

		}

		return total;// max size
	} // O(1)

	public List<List<Integer>> findSubsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);

		dfs(nums, 0, new ArrayList<Integer>(), result);

		return result;
	}

	private void dfs(int[] nums, int level, List<Integer> sol, List<List<Integer>> result) // sol.add() remove.()
	{
		if (nums.length == level) { // level == nums.length / sol ? empty 0
			result.add(new ArrayList<Integer>(sol));
			return;
		}

		sol.add(nums[level]);
		dfs(nums, level + 1, sol, result);
		sol.remove(sol.size() - 1);// logic error out of bounds

		while (level < nums.length - 1 && nums[level] == nums[level + 1])
			level++;

		dfs(nums, level + 1, sol, result);
	}

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

}
