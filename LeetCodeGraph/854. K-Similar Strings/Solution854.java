
public class Solution854 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ab";
		String B = "ba";
		new Solution854().kSimilarity(A, B);
	}
	
    //DFS + greedy.
    //How many levels? A.length or b.length;
    //How many status in each level? if a[x] = b[x] then 0, otherwise swap to a[y] that a[y] = b[x]; N statuses 
    //Greedy, if there are multiple a[y1] a[y2] = b[x], consider if any a[x] = b[y] only 
    public int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        return dfs(a, b, 0);
    }
    
    
    private int dfs(char[] a, char[] b, int i) {
        if (i >= a.length) return 0;
        if (a[i] == b[i]) return dfs(a, b, i + 1);
        int minSwap = Integer.MAX_VALUE;
        for(int j = i + 1; j < a.length; j++) {
            if(a[j] == b[i] && a[j] != b[j]) {
                swapCharArray(a, i, j);
                minSwap = Math.min(minSwap, 1 + dfs(a, b, i + 1));
                swapCharArray(a, i, j);
                if(a[i] == b[j]) break;
            }
        }
        return minSwap;
    }
    
    private void swapCharArray(char[] a, int index1, int index2) {
        char temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
