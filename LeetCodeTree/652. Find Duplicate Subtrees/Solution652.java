import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import generator.TreeNode;

public class Solution652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.map = new HashMap<>();
        this.res = new LinkedList<>();
        findDuplicateSubtreesPostOrder(root);
        return res;
    }
    
    private String findDuplicateSubtreesPostOrder(TreeNode root){
        if (root == null) return "";
        String uid = root.val +","+ findDuplicateSubtreesPostOrder(root.left) +","+ findDuplicateSubtreesPostOrder(root.right);
        int count = map.getOrDefault(uid, 0) + 1;
        map.put(uid, count);
        if(count == 2){
            res.add(root);
        }
        return uid;
    }
}
