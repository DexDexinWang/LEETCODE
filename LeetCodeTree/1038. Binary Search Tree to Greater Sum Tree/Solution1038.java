
public class Solution1038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1. Traverse Tree to get sum of all nodes. 
	//2. in-order traverse the tree. 
    public TreeNode bstToGst(TreeNode root) {
        int sum = sumTree(root);
        return refactorTree(root, new int[]{sum});
    }
    
    public TreeNode refactorTree(TreeNode root, int[] sum) {
        if(root == null) return root;
        root.left = refactorTree(root.left, sum);
        int temp = root.val;
        root.val = sum[0];
        sum[0] = sum[0] - temp;
        root.right = refactorTree(root.right, sum);
        return root;
    }
    
    public int sumTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }

}
