import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import generator.TreeNode;

public class Solution297 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(1);
		root1.right = new TreeNode(2);
				
		
		Solution297 test = new Solution297();
		String s  = test.serialize1(root1);
		TreeNode newRoot = test.deserialize1(s);
		System.out.print(newRoot.val);
	}
	Map<Integer,Integer> inorderIndex = new HashMap<>();
    
    int[] preOrder;
    
    // Decodes your encoded data to tree.
    int preOrderIndex = 0;

    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] orders = data.split(";");
        String[] preOrderValues = orders[0].split(",");
        String[] inOrderValues = orders[1].split(",");
        this.preOrder = new int[preOrderValues.length];
        for(int i = 0; i < preOrderValues.length; i++) {
            preOrder[i] = Integer.parseInt(preOrderValues[i]);
            inorderIndex.put(Integer.parseInt(inOrderValues[i]), i);
        }
        return generateTreePreOrder(0,this.preOrder.length);
    }
    public TreeNode deserialize1(String data) {
         String[] s = data.split(",");
         List<String> data_list = new LinkedList<String>(Arrays.asList(s));
         return deserialize1(data_list);
     }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializePostOrder(root, sb);
        sb.deleteCharAt(sb.length() -1);
        StringBuilder sb1 = new StringBuilder();
        serializeInOrder(root, sb1);
        sb1.deleteCharAt(sb1.length() -1);
        return sb.toString() + ";" + sb1.toString();
    }
    // Encodes a tree to a single string.
    // Encodes a tree to a single string.
     public String serialize1(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         serializePostOrder1(root, sb);
         sb.deleteCharAt(sb.length() -1);
         return sb.toString();
     }
    
    private TreeNode deserialize1(List<String> data_list) {
         if(data_list.get(0).equals("null")) {
             data_list.remove(0);
             return null;
         }
         TreeNode root = new TreeNode(Integer.valueOf(data_list.get(0)));
         data_list.remove(0);
         root.left = deserialize1(data_list);
         root.right = deserialize1(data_list);
         return root;
     }
    
    
    
    
	 private TreeNode generateTreePreOrder(int inLeft, int inRight) {
        if (inLeft == inRight) return null;
        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIndex.get(rootVal);
        root.left = generateTreePreOrder(inLeft, mid);
        root.right = generateTreePreOrder(mid + 1, inRight);
        return root;
    }
     
     private void serializeInOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        serializeInOrder(root.left, sb);
        sb.append(root.val+",");
        serializeInOrder(root.right, sb);
    }
     
     
     
     private void serializePostOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val+",");
        serializePostOrder(root.left, sb);
        serializePostOrder(root.right, sb);
    }
     
     private void serializePostOrder1(TreeNode root, StringBuilder sb) {
         if (root == null) {
             sb.append("null,");
         } else {
             sb.append(root.val+",");
             serializePostOrder(root.left, sb);
             serializePostOrder(root.right, sb);
         }
     }
}
