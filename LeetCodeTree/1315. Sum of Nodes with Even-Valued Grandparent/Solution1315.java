import generator.TreeNode;

public class Solution1315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Pre-orde
    //left and right: expecting sum the values if left or right node`s parent is event grandparent
    //current: if the current node`s grandparent is event then sum the tree. Update isEvenParent isEventGrandParent
    //return: nothing.
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sumEventGrandParentPreOrder(root, false, false);
        return sum;
    }
    
    public void sumEventGrandParentPreOrder(TreeNode root, boolean isEvenParent, boolean isEventGrandParent) {
        if (root == null)  return;
        if (isEventGrandParent) sum += root.val;
        isEventGrandParent = isEvenParent;
        isEvenParent = root.val  % 2 == 0;
        sumEventGrandParentPreOrder(root.left, isEvenParent, isEventGrandParent);
        sumEventGrandParentPreOrder(root.right, isEvenParent, isEventGrandParent);
    }
}
