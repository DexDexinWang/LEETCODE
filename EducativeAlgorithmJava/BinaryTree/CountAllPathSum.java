import java.util.HashMap;
import java.util.Map;

class CountAllPathSum {
	static int globalSum = 0;

	public static int countPaths(TreeNode root, int S) {
		if (root == null)
			return globalSum;
		Map<Integer, Integer> count = new HashMap<>();
		count.put(0, 1);
		countPaths(root, S, 0, count);
		return globalSum;
	}

	public static void countPaths(TreeNode root, int target, int preSum, Map<Integer, Integer> count) {
		if (root == null)
			return;
		preSum += root.val;
		int diff = preSum - target;
		if (count.containsKey(diff)) {
			globalSum += count.get(diff);
		}
		count.put(preSum, count.getOrDefault(preSum, 0) + 1);
		countPaths(root.left, target, preSum, count);
		countPaths(root.right, target, preSum, count);
		count.put(preSum, count.get(preSum) - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
	}
}
