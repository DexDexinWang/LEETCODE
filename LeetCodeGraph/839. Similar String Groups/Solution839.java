
public class Solution839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Find and Union 
    int[] parent;
    int[] height;
    public int numSimilarGroups(String[] A) {
        int len = A.length;
        parent = new int[len];
        height = new int[len];
        for(int i = 0; i < len; i++) {
            parent[i] = i;
        }
        
        int size = len;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i; j < len; j++) {
                if(isSimilar(A[i], A[j])) {
                    int pa = find(i);
                    int pb = find(j);
                    if(pa != pb) {
                        union(pa, pb);
                        size--;
                    }
                }
            }
        }
        return size;
    }
    
    private void union(int i, int j) {
        if(height[i] < height[j]) {
            parent[j] = i;
        } else if (height[i]> height[j]) {
            parent[i] = j;
        } else {
            parent[i] = j;
            height[i]++;
        }
    }
    
    private int find (int index) {
        if(parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
    
    private boolean isSimilar(String a, String b) {
        if(a.length() != b.length()) return false;
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[] positions = new int[2];
        int index = 0;
        for(int i = 0; i < a.length(); i++) {
            if(c1[i]!= c2[i]){
                if(index >=2 ) return false;
                positions[index++] = i;
            }
        }
        if (index == 0) return true;
        return (c1[positions[0]] == c2[positions[1]] && c1[positions[1]] == c2[positions[0]]);
    }
}
