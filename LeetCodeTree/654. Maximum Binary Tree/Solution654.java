import generator.TreeNode;

public class Solution654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //Inorder
    //left and right: expect returning stasified subtree.
    //current: get max value and its index, genrate root. max index will be passed to recursion methods
    //return: it will return the current root.
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTreeInorder(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaximumBinaryTreeInorder(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int max = nums[left];
        int maxIndex = left;
        for(int i = left + 1; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTreeInorder(nums, left, maxIndex - 1);
        root.right = constructMaximumBinaryTreeInorder(nums, maxIndex + 1, right);
        return root;
    }

}
