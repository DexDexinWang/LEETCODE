import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution663 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Post Order, get sum for each subtree, and each subtree`s value is sum/2;
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return false;
        Deque<Integer> sums = new LinkedList<>();
        int total = GetSum(root, sums);
        sums.pollLast();
        if(total%2 != 0) return false;
        for(int num: sums) {
            if (num == total / 2) return true;
        }
        return false;
    }
    
    private int GetSum(TreeNode root, Deque<Integer> sums) {
        if (root == null) return 0;
        int leftSum = GetSum (root.left, sums);
        int rightSum = GetSum (root.right, sums);
        sums.offerLast(leftSum + rightSum + root.val);
        return sums.peekLast();
    }
}
