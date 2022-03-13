import java.util.HashMap;
import java.util.Map;

import generator.TreeNode;

public class Solution106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution106 s = new Solution106();
		s.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
	}
	
	/*
	 * 9 3 15 20 7
	 * 9 15 7 20 3
	 * 
	 * 
	 * 							3
	 * 					|				|
	 * 				sub{9}     			sub - inorder{15 20 7}  postorder {15 7 20}   -> 20   
	 * 
	 * 								|		|
	 * 								15		7								
	 * 
	 * */
    int globalIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = inorder.length;
        globalIndex = len - 1;
        for(int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return findNode(postorder, 0, len - 1, map);
    }
    
    private TreeNode findNode(int[] postorder, int left, int right, Map<Integer, Integer> map) {
        if (left > right) return null;
        int target = postorder[globalIndex--];
        TreeNode root = new TreeNode(target);
        if(left == right) return root;
        int index = map.get(target);
        root.right = findNode(postorder, index + 1, right, map);
        root.left = findNode(postorder, left, index - 1, map);
        return root;
    }
}
