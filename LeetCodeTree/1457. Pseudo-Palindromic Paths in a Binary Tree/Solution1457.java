import java.util.HashMap;
import java.util.Map;

import generator.TreeNode;

public class Solution1457 {
    int total = 0;
    public boolean checkPalindromic(Map<Integer, Integer> map) {
        boolean hasUnit = false;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                if (hasUnit) {
                    return false;
                }
                hasUnit = true;
            }
        }
        return true;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        pseudoPalindromicPaths(root, map);
        return total;
    }
    
    public void pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> map){
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if(root.left == null && root.right == null) {
            total += checkPalindromic(map) ? 1 : 0;
        } else {
            pseudoPalindromicPaths(root.left, map);
            pseudoPalindromicPaths(root.right, map);
        }
        map.put(root.val, map.get(root.val) - 1);
    }
}
