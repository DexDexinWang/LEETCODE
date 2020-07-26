
public class Solution5472 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5472().restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
	}
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < indices.length; i++) {
            int temp = i;
            while(indices[temp] != temp) {
            	int curr = indices[temp];
                swapIndices(indices, temp, curr);
                swapChars(chars, temp, curr);
            }
        }
        return new String(chars);
    }
    
    private void swapIndices(int[] indices, int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }
    
    private void swapChars(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
