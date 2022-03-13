import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1239 solution = new Solution1239();
		int res = solution.maxLength(Arrays.asList(new String[] {"un","iq","ue"}));
		System.out.print(res);
	}
	
	
    //DFS solution
    //For each element in arr, there are 2 potions: concate element or not.
    //Concat, if has conflict. break the branch. 
    //Concat, if that is the latest element. compare max length. 
    
    Integer max;
    public int maxLength(List<String> arr) {
        max = 0;
        conateElement(arr, 0, new HashSet<>());
        return max;
    }
    
    private void conateElement(List<String> arr, int index, Set<Character> set) {
        if (index == arr.size()) {
            max = Math.max(max, set.size());
            return;
        }
        conateElement(arr, index + 1, set);
        
        String temp = arr.get(index);
        int i = 0; 
        boolean isAdded = true;
        while(i < temp.length()) {
            if(!set.add(temp.charAt(i))) {
                isAdded = false;
                break;
            }
            i++;
        }
        if(isAdded) {
            conateElement(arr, index + 1, set);
        }
        while (i - 1 >= 0) {
            set.remove(temp.charAt(i-1));
            i--;
        }
    }
}
