class SumOfPathNumbers {
	static int sum = 0;

	public static int findSumOfPathNumbers(TreeNode root) {
		if (root == null)
			return sum;
		findSumDFS(root, 0);
		return sum;
	}

	public static void findSumDFS(TreeNode root, int val) {
		val = val * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += val;
		} else {
			if (root.left != null)
				findSumDFS(root.left, val);
			if (root.right != null)
				findSumDFS(root.right, val);
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}
}
