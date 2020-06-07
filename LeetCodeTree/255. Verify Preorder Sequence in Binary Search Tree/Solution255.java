
public class Solution255 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution255().verifyPreorder(new int[] {5,2,1,3,6});
	}
	
	public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE, i = -1;
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (i >= 0 && p > preorder[i])
	            low = preorder[i--];
	        preorder[++i] = p;
	    }
	    return true;
	}
	
    //Pre-Order with min and max parameters
    //Left and Right: expecting subtrees are binary search tree
    //current: find root val and find values in left subtree and values in right subtree, then pass these values into recursion.
    //return: if root val is not min< root < max, or the any subtree is not bst return flase; otherwise return true
    public boolean verifyPreorder1(int[] preorder) {
        return verifyPreorderMinMax(preorder, 0, preorder.length -1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean verifyPreorderMinMax(int[] preorder, int start, int end, int min, int max) {
        if (start > end) return true;
        int root = preorder[start++];
        if(root < max && root > min) {
            int mid = start;
            while(mid < preorder.length && preorder[mid] < root){
                mid++;
            }
            boolean leftRes = verifyPreorderMinMax(preorder, start, mid - 1, min, root);
            boolean rightRes = verifyPreorderMinMax(preorder, mid, end, root, max);
            return leftRes && rightRes;
        }
        return false;
    }
}
