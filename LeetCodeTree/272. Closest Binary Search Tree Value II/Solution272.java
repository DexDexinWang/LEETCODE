import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Inorder with LinkedList
    //if list.size() < k just add curr value
    //list.size() >= k, compare the first.value diff and current value diff
    //return nothing.
    boolean isBreak = false;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null || k == 0) {
            return res;
        }
        closestKVqaluesInOrder(root, target, k, res);
        return res;
    }
    
    public void closestKVqaluesInOrder(TreeNode root, double target, int k , List<Integer> res) {
        if (root == null || isBreak) return;
        closestKVqaluesInOrder(root.left, target, k, res);
        if(res.size() < k) {
            res.add(root.val);
        } else {
            if (Math.abs(res.get(0) - target) > Math.abs(root.val -target)) {
                res.remove(0);
                res.add(root.val);
            } else {
                isBreak = true;
            }
        }
        closestKVqaluesInOrder(root.right, target, k, res);
    } 

}
