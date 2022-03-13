package generator;

public class Solution1379 {
    TreeNode res = null;
    public void findTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(res != null || original == null) return;
        if (original == target) {
            res = cloned;
        } 
        findTargetCopy(original.left, cloned.left, target);
        findTargetCopy(original.right, cloned.right, target);
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        findTargetCopy(original, cloned, target);
        return res;
    }
}
