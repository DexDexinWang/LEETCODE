import generator.TreeNode;

public class DiameterofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		DiameterofBinaryTree test = new DiameterofBinaryTree();
		test.diameterOfBinaryTree(root);
	}

	 public int longest = Integer.MIN_VALUE;
	    //For each level - Action1, it will get the the path number from current root to left child and right child
	    //For each level - Action2, add left path number and right path number. Then, compare to the global max path.
	    //For each level - Return, return the maximum path number between left child and right child  + 1.
	    public int diameterOfBinaryTree(TreeNode root) {
	        if (root == null || root.left == null && root.right == null) {
	            return 0;
	        } 
	        getLongestPath(root);
	        return longest;
	    }
	    
	    public int getLongestPath(TreeNode root) {
	        if (root == null) {
	            return 0;
	        } else if (root.left == null && root.right == null) {
	            return 1;
	        } else {
	            int leftLen = getLongestPath(root.left);
	            int rightLen = getLongestPath(root.right);
	            longest = Math.max(leftLen + rightLen, longest);
	            return Math.max(leftLen, rightLen) + 1;
	        } 
	    }
}
