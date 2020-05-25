import generator.TreeNode;

public class Solution666 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int ans = 0;
    public int pathSum(int[] nums) {
        TreeNode root = new TreeNode(nums[0] % 10);
        for(int i = 1; i <nums.length; i++) {
            int depth = nums[i] /100;
            int pos = nums[i] /10 % 10;
            pos--;
            int val = nums[i] % 10; 
            TreeNode cur = root;
            for(int d = depth - 2; d >=0; d--) {
                if (pos < (1<<d) ) {
                    if (cur.left == null) cur.left = new TreeNode(val);
                    cur = cur.left;
                } else {
                    if (cur.right == null) cur.right = new TreeNode(val);
                    cur = cur.right;
                }
                pos = pos % (1<<d);
            }
        }
        dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum += root.val;
        if (root.left == null && root.right == null) {
            ans+= sum;
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }

}
