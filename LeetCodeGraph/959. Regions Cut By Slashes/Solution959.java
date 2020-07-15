
public class Solution959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Each grid could be divided by 4 parts: 
    //   0
    // 1   2
    //   3
    //Union Find solution, if not \\ then union 0,1  2,3, if not / then union 0,2 1,3
    //Union neighbors
    public int regionsBySlashes(String[] grid) {
        int size = grid.length;
        UF uf = new UF(4*size*size);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int root = 4 * (i * size + j);
                char val = grid[i].charAt(j);
                if(val != '\\') {
                    uf.union(root + 0,  root + 1);
                    uf.union(root + 2,  root + 3);
                } 
                if (val != '/') {
                    uf.union(root + 0,  root + 2);
                    uf.union(root + 1,  root + 3);
                }
                //South 
                if(i + 1 < size) uf.union(root + 3, (root + 4*size) + 0);
                if (i - 1 >= 0) uf.union(root + 0, (root - 4*size) + 3);
                if(j + 1 < size) uf.union(root + 2, (root + 4) + 1);
                if (j - 1 >= 0) uf.union(root + 1, (root - 4) + 2);
            }
        }
        int res = 0;
        for(int i = 0; i < 4*size * size; i++) {
            if(uf.find(i) == i) {
                res++;
            }
        }
        return res;
    }
    
    class UF{
        int[] parent;
        public UF(int size) {
            parent = new int[size];
            for(int i = 0; i < size; i++) {
                parent[i]= i;
            }
        }
        
        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
