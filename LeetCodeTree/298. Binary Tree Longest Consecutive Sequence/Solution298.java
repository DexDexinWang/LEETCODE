import generator.TreeNode;

public class Solution298 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Preorder with parent value and the number of existing presequence
    //current: if current val is equal 1 + parent.val, len++; otherwise, prevLen = 1. Update globalMaxLen
    private int globalMaxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        longestConsecutive(root, root.val, 0);
        return globalMaxLen;
    }
    private void longestConsecutive(TreeNode root, int parentVal, int prevLen) {
        if (root == null) return;
        if(root.val == parentVal + 1) {
            prevLen++;
        } else {
            prevLen = 1;
        }
        globalMaxLen = Math.max(globalMaxLen, prevLen);
        longestConsecutive(root.left, root.val, prevLen);
        longestConsecutive(root.right, root.val, prevLen);
    }
}
