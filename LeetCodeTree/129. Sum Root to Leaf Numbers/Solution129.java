import generator.TreeNode;

public class Solution129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new Solution129().sumNumbers(root));
	}

    //Pre-order
    int globalSum; 
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbersPreOrder(root, 0);
        return globalSum;
    }
    
    private void sumNumbersPreOrder(TreeNode root, int num){
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            globalSum += num;
            return;
        }
        sumNumbersPreOrder(root.left, num);
        sumNumbersPreOrder(root.right, num);
    }
}
