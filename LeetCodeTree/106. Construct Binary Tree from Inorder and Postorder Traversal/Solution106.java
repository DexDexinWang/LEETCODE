import java.util.HashMap;
import java.util.Map;

import generator.TreeNode;

public class Solution106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    int[] inorder;
    int[] postorder;
    int postOrderIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postOrderIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(0, inorder.length);
    }
    
    private TreeNode buildTree(int inLeft, int inRight) {
        if(inLeft == inRight) return null;
        int rootVal = postorder[postOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        postOrderIndex--;
        int index = map.get(rootVal);
        root.right = buildTree(index+1, inRight);
        root.left = buildTree(inLeft, index);
        return root;
    }
}
