import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Soultion1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int globalSum = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverseTree(root,new LinkedList<>());
        return globalSum;
    }
    
    //Solution2
    public int sumRootToLeaf2(TreeNode root) {
    	int sum = 0;
        traverseTree2(root,sum);
        return globalSum;
    }
    
    private int calculateBitValues(List<Integer> list) {
        int num = 0;
        for(int i = list.size() - 1; i >= 0 ; i--) {
            if (list.get(i) == 1) {
                num += Math.pow(2, (list.size() - 1 - i));
            }
        }
        return num;
    }
    
    private void traverseTree(TreeNode root, List<Integer> list) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
            globalSum+= calculateBitValues(list);
            list.remove(list.size()-1);
        }
        list.add(root.val);
        if(root.left != null) traverseTree(root.left, list);
        if(root.right != null) traverseTree(root.right, list);
        list.remove(list.size() - 1);
    }
    
    private void traverseTree2(TreeNode root, int sum) {
    	sum = (sum << 1) + root.val; 
        if(root.left == null && root.right == null) {
            globalSum+= sum;
        }
        if(root.left != null) traverseTree2(root.left, sum);
        if(root.right != null) traverseTree2(root.right, sum);
    }
    
}
