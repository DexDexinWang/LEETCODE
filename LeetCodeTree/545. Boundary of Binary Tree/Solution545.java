import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution545 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Make node as flag
    //root = 0;
    //LeftBoundary= 1;
    //RightBoundary = 2;
    //Others = 3;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();
        List<Integer> leaveList = new LinkedList<>();
        boundaryOfBinaryTreePreOrder(root, leftList, rightList, leaveList, 0);
        leftList.addAll(leaveList);
        leftList.addAll(rightList);
        return leftList;
    }
    
    private void boundaryOfBinaryTreePreOrder(TreeNode root, List<Integer> leftList, List<Integer> rightList, List<Integer> leaveList, int flag){
        if(root == null) return;
        if(isRightBoundary(flag)) {
            rightList.add(0, root.val);
        } else if (isLeftBoundary(flag) || isRoot(flag)) {
            leftList.add(root.val);
        } else if (root.left == null && root.right == null) {
            leaveList.add(root.val);
        }
        boundaryOfBinaryTreePreOrder(root.left, leftList, rightList, leaveList, leftChildFlag(root, flag));
        boundaryOfBinaryTreePreOrder(root.right, leftList, rightList, leaveList, rightChildFlag(root, flag));
    }
    
    private boolean isLeftBoundary(int flag) {
        return flag == 1;
    }
    
    private boolean isRightBoundary(int flag) {
        return flag == 2;
    }
    
    private boolean isRoot(int flag) {
        return flag == 0;
    }
    
    private int leftChildFlag(TreeNode root, int flag) {
        if(isLeftBoundary(flag) || isRoot(flag)) {
            return 1; 
        } else if (isRightBoundary(flag) && root.right == null) {
            return 2; 
        } else {
            return 3;
        }
    }
    
    private int rightChildFlag(TreeNode root, int flag) {
        if(isRightBoundary(flag) || isRoot(flag)) {
            return 2; 
        } else if (isLeftBoundary(flag) && root.left == null) {
            return 1; 
        } else {
            return 3;
        }
    }

}
