import generator.TreeNode;

public class Solution1120 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(1);
		new Solution1120().maximumAverageSubtree(root);

	}
    //left and right: expect sum and ndoecount from left subtree and right subtree
    //current: (current.val + leftSum + rightSum) / (leftNodeNum + rightNodeNum + 1) and record if it is maximum;
    //return: sum res and count
    double maximumAverage;
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maximumAverageSubtreePostOrder(root);
        return maximumAverage;
    }
    
    public int[] maximumAverageSubtreePostOrder(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int[] leftRes = maximumAverageSubtreePostOrder(root.left);
        int[] rightRes = maximumAverageSubtreePostOrder(root.right);
        int sum = leftRes[0] + rightRes[0] + root.val;
        int count = leftRes[1] + rightRes[1] + 1;
        double currentAverage = (double) sum / count;
        maximumAverage = Math.max(maximumAverage, currentAverage);
        return new int[]{sum,count};
    }
}
