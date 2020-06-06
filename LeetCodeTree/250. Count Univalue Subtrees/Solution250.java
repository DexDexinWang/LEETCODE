import generator.TreeNode;

public class Solution250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Post order
    //left and right: expecting subtree is a uni-value subtree. 
    //current: if left subtree and right subtree are uni-values subtrees, check left node and right node and root node has the same value or not.
    //return: the current subtree is a uni-vlaue subtree.
    int globalCount = 0;
    public int countUnivalSubtrees(TreeNode root) {
        countUnivalSubtreesPostOrder(root);
        return globalCount;
    }
    
    public boolean countUnivalSubtreesPostOrder(TreeNode root) {
        if (root == null) return true;
        boolean isLeftUVST =  countUnivalSubtreesPostOrder(root.left);
        boolean isRightUVST = countUnivalSubtreesPostOrder(root.right);
        
        boolean isCurrUVST = false;
        if(isLeftUVST && isRightUVST) {
            isCurrUVST = (root.left == null? root.val : root.left.val) == (root.right == null? root.val : root.right.val);
            isCurrUVST = isCurrUVST && ((root.left == null? root.val : root.left.val) == root.val);
            if(isCurrUVST) this.globalCount += 1;
        }
        return isCurrUVST;
    }
}
