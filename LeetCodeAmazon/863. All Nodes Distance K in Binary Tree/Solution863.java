import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    //It will consider 2 situations:
    //First, if the target node is ancestor, find k distinct target in subtree
    //Second, if the target node is in a subtree, if distince < K check another tree. if K, add root. otherwise ignore it.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        findTarget(root, target, K, res);
        return res;
    }
    
    public int findTarget(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if(root == null) return -1;
        if(root == target) {
            findRes(root, K, res);
            return K -1;
        }
        int left = findTarget(root.left, target, K, res);
        int right = findTarget(root.right, target, K, res);
        if(left == -1 && right == -1) {
            return -1;
        } else if (left != -1) {
            if(left == 0) {
                res.add(root.val);
                return -1;
            } else {
                findRes(root.right, left - 1, res);
                return left - 1;
            }
        } else {
            if(right == 0) {
                res.add(root.val);
                return -1;
            } else {
                findRes(root.left, right - 1, res);
                return right -1;
            }
        }
    }
    
    public void findRes(TreeNode root, int distance, List<Integer> res) {
        if(root == null) return;
        if(distance == 0) res.add(root.val);
        findRes(root.left, distance - 1, res);
        findRes(root.right, distance - 1, res);
    }
}
