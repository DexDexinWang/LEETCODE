import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		System.out.println(new Solution655().printTree(root));
	}
	
    //DFS, get height to know the size of each list. if h = 1 then 1, else 2^h - 1;
    //DFS, update res by calculate mid index
    public List<List<String>> printTree(TreeNode root) {
        //Corner cases
        List<List<String>> res = new LinkedList<>();
        if(root == null) return null;
        List<String> firstList = new LinkedList<>();
        if(root.left ==null && root.right == null){
            firstList.add(root.val+"");
            res.add(firstList);
            return res;
        }
        //Get Height;
        int height = getTreeHight(root, 1);
        int lineSize = (1<<height) - 1;
        for(int i = 0; i < height; i++) {
            List<String> list = new LinkedList<>();
            for(int j = 0; j < lineSize; j ++) {
                list.add("");
            }
            res.add(list);
        }
        updateListByPreOrder(root, 0, 0, lineSize - 1, res);
        return res;
    }
    
    private int getTreeHight(TreeNode root, int h) {
        if(root == null) return h - 1;
        return Math.max(getTreeHight(root.left, h + 1),getTreeHight(root.right, h + 1));
    }
    
    private void updateListByPreOrder(TreeNode root, int height, int begin, int end, List<List<String>> res) {
        if(root == null) return;
        int mid = begin + (end - begin) / 2; 
        List<String> list = res.get(height);
        list.set(mid, root.val+"");
        updateListByPreOrder(root.left, height + 1, begin, mid - 1, res);
        updateListByPreOrder(root.right, height + 1, mid + 1, end, res);
    }
}
