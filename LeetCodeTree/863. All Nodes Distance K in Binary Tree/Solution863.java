import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Two kind of DFS: 
    //1. DFS post order, Check whether there exist target in subtrees.
    //left right: expect returning the target path.
    //current: if root == target, do 2nd DFS with root. if left subtree contains dfs, do 2nd DFS with right Subtree same as that left subtree contains target.
    //2. DFS pre order with given distinct. 
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        preOrderCheck(root, target, K, res);
        return res;
    }
    
    private void PostOrderCheck(TreeNode root, int distinct, int K, List<Integer> res) {
        if (root == null) return;
        if (K == distinct) {
            res.add(root.val);
        } else if (K < distinct) {
            return;
        } else {
            PostOrderCheck(root.left, distinct + 1, K, res);
            PostOrderCheck(root.right, distinct + 1, K, res);
        }
    }
    
    private int preOrderCheck(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) return -1;
        if (root == target) {
            PostOrderCheck(root, 0, K, res);
            return 1;
        } 
        int left = preOrderCheck(root.left, target, K, res);
        int right = preOrderCheck(root.right, target, K, res);
        if(left != -1) {
            if (left == K) res.add(root.val);
            else PostOrderCheck(root.right, left + 1 , K, res);
            return left + 1;
        } else if (right != -1) {
            if (right == K) res.add(root.val);
            else PostOrderCheck(root.left, right + 1, K, res);
            return right + 1;
        } else {
            return -1;
        }
    }
}
