import generator.TreeNode;

public class Solution1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length -1);    
    }
    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start++]);
        int mid = start;
        while (mid < preorder.length && preorder[mid] < root.val) {
            mid++;
        }
        root.left = bstFromPreorder(preorder, start, mid - 1);
        root.right = bstFromPreorder(preorder, mid, end);
        return root;
    }
}
