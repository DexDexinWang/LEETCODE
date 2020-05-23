import generator.TreeNode;

public class Solution1026 {
    //Each level: it should claculate differ between (root.val, min) and (root.val, max) and update global max; then, update min and max;
    int globalMax = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffPreOrder(root, root.val, root.val);
        return globalMax;
    }
    
    private void maxAncestorDiffPreOrder(TreeNode root, int min, int max) {
        if (root == null) return;
        globalMax = Math.max(globalMax,Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        maxAncestorDiffPreOrder(root.left, min, max);
        maxAncestorDiffPreOrder(root.right, min, max);
    }
}
