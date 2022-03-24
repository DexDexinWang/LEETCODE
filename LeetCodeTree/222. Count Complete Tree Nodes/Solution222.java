import generator.TreeNode;

public class Solution222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int depth = countDepth(root);
        if(depth == 1) return 1;
        int left = 1, right = (int)Math.pow(2,depth) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if(checkLeave(root, pivot, depth)) left = pivot + 1;
            else right = pivot - 1;
        }
        return (int)Math.pow(2,depth) - 1 + left;
    }
    
    //Recursion
    public int countNodes1(TreeNode root) {
    	return root == null? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean checkLeave(TreeNode root, int index, int depth) {
        int left = 0, right = (int)Math.pow(2,depth) - 1;
        int pivot;
        for(int i = 0; i < depth; i++) {
            pivot = left + (right - left) / 2;
            if(index <= pivot) {
                root = root.left;
                right = pivot;
            } else {
            	root = root.right;
                left = pivot + 1;
            }
        }
        return root != null;
    }
    
    private int countDepth(TreeNode root) {
        int count = 0;
        while(root!= null) {
            root = root.left;
            count++;
        }
        return count;
    }

}
