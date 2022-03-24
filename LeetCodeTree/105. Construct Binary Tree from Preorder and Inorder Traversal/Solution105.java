import java.util.HashMap;

import generator.TreeNode;

public class Solution105 {

	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,7};
		int[] inorder = new int[] {9,3,20,7};
		new Solution105().buildTree(preorder, inorder);
	}
	
    private int preOrderIndex = 0;
    HashMap<Integer,Integer> index_map = new HashMap<>();
    int[] inorder;
    int[] preorder;
    public TreeNode buildTree(int inLeft, int inRight) {
        if(inLeft == inRight) {
            return null;
        }
        int rootVal = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = index_map.get(rootVal);
        preOrderIndex++;
        root.left = buildTree(inLeft, index);
        root.right = buildTree(index + 1, inRight);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; i++) {
            index_map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length);
    }
    
}
