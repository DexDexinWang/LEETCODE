import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution1339 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProduct(TreeNode root) {
        Deque<Integer> sums = new LinkedList<>();
        int totalSum = maxProductPostOrder(root, sums);
        long best = 0;
        for(long sum : sums) {
            best= Math.max(best, sum * (totalSum - sum));
        }
        return (int)(best % 1000000007);
    }
    
    private int maxProductPostOrder(TreeNode root, Deque<Integer> sums){
        if (root == null) return 0;
        int leftSum = maxProductPostOrder(root.left, sums);
        int rightSum = maxProductPostOrder(root.right, sums);
        sums.offerLast(leftSum + rightSum + root.val);
        return sums.peekLast();
    }
    
}
