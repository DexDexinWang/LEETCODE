import generator.TreeNode;

public class Solution333 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		System.out.println(new Solution333().largestBSTSubtree(root1));
	}

    int max = 0; 
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        largestBSTSubtreePostOrfer(root, null, null);
        return max;
    }
    
    public Res largestBSTSubtreePostOrfer(TreeNode root, Integer min, Integer max) {
        if (root == null) return new Res(true,0);
        if (min != null && root.val <= min) return new Res(false, 0);
        if (max != null && root.val >= max) return new Res(false, 0);
        Res left = largestBSTSubtreePostOrfer(root.left, min, root.val);
        Res right = largestBSTSubtreePostOrfer(root.right, root.val, max);
        boolean isBST = true;
        int total = 1;
        if (left.isBST) {
            isBST = root.left != null ? root.val > root.left.val : true;
        } else {
            isBST = false;
        }
        if (right.isBST) {
            isBST = isBST && (root.left != null ? root.val < root.right.val : true);
        } else {
            isBST = false;
        }
        total += left.total;
        total += right.total;
        if (isBST) max = Math.max(max, total);
        return new Res(isBST, total);
    }
    
    class Res{
        boolean isBST;
        int total;
        public Res(boolean isBST, int total) {
            this.isBST = isBST;
            this.total = total;
        }
    }
}
