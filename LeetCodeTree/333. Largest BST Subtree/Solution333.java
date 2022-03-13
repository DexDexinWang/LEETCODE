import generator.TreeNode;

public class Solution333 {

	class Res{
        boolean isBST;
        int max;
        int min;
        int total;
        public Res(boolean isBST, int total) {
            this.isBST = isBST;
            this.total = total;
        }
        
        public Res(boolean isBST, int total, int min, int max) {
            this.isBST = isBST;
            this.total = total;
            this.min = min;
            this.max = max;
        }
        
        public Res(int total, int min, int max) {
            this.total = total;
            this.min = min;
            this.max = max;
        }
    }

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
    //Post-Order
    //left and right: expecting return 2 values: sutree is bst or not, number of nodes
    //current: if left and right are subtree, check leftSubTree.max < current.val < rightSubTree.min (if yes, update global), and update nodes.
    //return: current tree is bst or not, number of nodes
    int globalMax = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        largestBSTSubtreePostOrder(root);
        return globalMax;
    }
    
    //Post-Order
    //left and right: expecting return 2 values: sutree is bst or not, number of nodes
    //current: if left and right are subtree, check leftSubTree.max < current.val < rightSubTree.min (if yes, update global), and update nodes.
    //return: current tree is bst or not, number of nodes
    public int largestBSTSubtree1(TreeNode root) {
        return largestBSTSubtreeHelper(root).total;
    }
    
    
    public Res largestBSTSubtreeHelper(TreeNode root) {
        if(root == null) return new Res(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Res leftRes = largestBSTSubtreeHelper(root.left);
        Res rightRes = largestBSTSubtreeHelper(root.right);
        if(root.val > leftRes.max && root.val < rightRes.min) {
            return new Res(root.left == null ? root.val: leftRes.min, root.right == null ? root.val : rightRes.max, leftRes.total + rightRes.total + 1);
        } else {
            return new Res(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftRes.total, rightRes.total));
        }
    }
    
    public Res largestBSTSubtreePostOrder(TreeNode root) {
        if (root == null) return new Res(true,0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Res left = largestBSTSubtreePostOrder(root.left);
        Res right = largestBSTSubtreePostOrder(root.right);
        boolean isBST = false;
        int total = left.total + right.total + 1;
        if(left.isBST && right.isBST) {
            isBST = root.val > left.max && root.val < right.min;
            if(isBST) globalMax = Math.max(globalMax, total); 
        }
        int min = root.left == null ? root.val : left.min;
        int max = root.right == null ? root.val : right.max;
        return new Res(isBST, total, min, max);
    }
    
 
}
