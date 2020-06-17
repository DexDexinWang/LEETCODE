import generator.TreeNode;

public class Solution889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, 0, pre.length);
    }
    
    private TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int postStart, int len) {
        if(len == 0) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if(len == 1) return root;
        int index = 1;
        for(; index < len; index++) {
            if(post[postStart + index - 1] == pre[preStart+1]) break;
        }
        
        root.left = constructFromPrePost(pre, post, preStart + 1, postStart, index);
        root.right = constructFromPrePost(pre, post, preStart + 1 + index, postStart + index, len - 1 - index);
        return root;
    }

}
