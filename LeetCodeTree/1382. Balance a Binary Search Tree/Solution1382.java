import java.util.LinkedList;
import java.util.List;

public class Solution1382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    /*
    1. convert the tree as ordered int[] array.
    2. create tree with left point, right point, and given array.
        a. if left point > right point return null;
        b. calculate middle 
        c. create root with middle node. 
        d. pass left pointer and right pointer with subtree.
    */
    public TreeNode balanceBST(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return root;
        }
        List<Integer> inOrderArray = new LinkedList<>();
        populateInOrderArray(root, inOrderArray);
        return generateTree(inOrderArray, 0, inOrderArray.size()-1);
    }
    
    private TreeNode generateTree(List<Integer> array, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left) /2;
        TreeNode root = new TreeNode(array.get(mid));
        root.left = generateTree(array, left, mid - 1);
        root.right = generateTree(array, mid + 1, right);
        return root;
    }
    
    private void populateInOrderArray(TreeNode root, List<Integer> array) {
        if (root == null) return;
        populateInOrderArray(root.left, array);
        array.add(root.val);
        populateInOrderArray(root.right, array);
    }
}
