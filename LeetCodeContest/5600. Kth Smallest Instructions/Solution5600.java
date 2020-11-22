
public class Solution5600 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String kthSmallestPath(int[] destination, int k) {
        int row = destination[0];
        int col = destination[1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <=col; i++) {
            sb.append("H");
        }
        for(int i = 0; i <= row; i++) {
            sb.append("V");
        }
        return "";
        
    }
    
    
    
}
