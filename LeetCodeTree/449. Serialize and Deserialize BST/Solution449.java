import generator.TreeNode;

public class Solution449 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void serializePreOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val+",");
        serializePreOrder(root.left, sb);
        serializePreOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] values = data.split(",");
        int[] nums = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }
        return generateBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode generateBST(int[] nums, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(nums[start++]);
        int mid = start;
        while(mid < nums.length && nums[mid] < root.val) {
            mid++;
        }
        root.left = generateBST(nums, start, mid - 1);
        root.right = generateBST(nums, mid, end);
        return root;
    }
}
