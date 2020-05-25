import generator.TreeNode;

public class Solution1372 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //In order
    //left and right: expecting the longest zigzag path. 
    //current: check current longest zigzag path with current node which will be regarded as left node or right node.
    //return: max zigzag path.
    int max = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZagPostOrder(root);
        return max;
    }
    //int[0] as left, int[0] as right
    public int[] longestZigZagPostOrder(TreeNode root) {
        if (root == null) return new int[]{-1,-1};
        int[] leftMax = longestZigZagPostOrder(root.left);
        int[] rightMax = longestZigZagPostOrder(root.right);
        int asLeft = rightMax[1] + 1;
        int asRight = leftMax[0] + 1;
        max = Math.max(max, Math.max(asLeft,asRight));
        return new int[]{asLeft, asRight};
    }
}
