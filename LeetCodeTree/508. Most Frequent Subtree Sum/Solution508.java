import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import generator.TreeNode;

public class Solution508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Post Order
    int maxOccurance = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        findFrequentTreeSumPostOrder(root, map);
        List<Integer> res= new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == maxOccurance) {
                res.add(entry.getKey());
            }
        }
        int[] finalRes = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
    
    public int findFrequentTreeSumPostOrder(TreeNode root, Map<Integer,Integer> map) {
        if (root == null) return 0;
        int leftSum = findFrequentTreeSumPostOrder(root.left, map);
        int rightSum = findFrequentTreeSumPostOrder(root.right, map);
        int totalSum = leftSum + rightSum + root.val;
        int occurance = map.getOrDefault(totalSum,0) + 1;
        maxOccurance = occurance > maxOccurance ? occurance : maxOccurance;
        map.put(totalSum, occurance);
        return totalSum;
    }
}
