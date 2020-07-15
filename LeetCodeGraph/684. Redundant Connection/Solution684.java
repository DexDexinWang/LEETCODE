
public class Solution684 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(1000 + 1);
        for(int[] edge :edges) {
            if(!dsu.union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }
    
    class DSU {
        int[] parent;
        int[] rank;
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if(xp == yp) return false;
            else if (rank[xp] < rank[yp]) parent[xp] = yp;
            else if (rank[xp] < rank[yp]) parent[yp] = xp;
            else {
                parent[yp] = xp;
                rank[xp]++;
            }
            return true;
        }
    }
}
