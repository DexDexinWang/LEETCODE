
public class Solution1448 {

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //For each node, it should the value and max value from root to current node. If current.val < max ? count++ : count = 0;
    //For left side, it should pass the max value, and expected the number of total good nodes in left right.
    //For right side, it should pass the max value, and expected the number of totoal good nodes in right sub-tree.
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int currentMax = Math.max(root.val, max);
        int countLeft = countGoodNodes(root.left, currentMax);
        int countRight = countGoodNodes(root.right, currentMax);
        return countLeft + countRight + (root.val >= max ? 1 : 0);
    }
}
