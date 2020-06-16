
public class Solution1257 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Treverse tree from child to parent. find the first crossed node and return it.
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> tree = new HashMap<>();
        generateTree(regions, tree);
        return findSmallestRegion(regions, region1, region2, tree);
    }
    
    public void generateTree(List<List<String>> regions, Map<String,String> tree) {
        if(regions!= null && regions.size() !=0) {
            for(List<String> line : regions) {
                String parent = line.get(0);
                for(int i = 1; i < line.size(); i++) {
                    String child = line.get(i);
                    tree.put(child,parent);
                }
            }
        }
    }
    
    private String findSmallestRegion(List<List<String>> regions, String region1, String region2, Map<String,String> tree) {
        Set<String> set = new HashSet<>();
        set.add(region1);
        while(tree.containsKey(region1)) {
            region1 = tree.get(region1);
            set.add(region1);
        }
        while(!set.contains(region2)) {
            region2 = tree.get(region2);
        }
        return region2;
    }

}
