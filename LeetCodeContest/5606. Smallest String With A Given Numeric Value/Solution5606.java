
public class Solution5606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5606 test = new Solution5606();
		System.out.println(test.getSmallestString(3, 27));
	}
    public String getSmallestString(int n, int k) {
        int total = k - n;
        int times = total / 25;
        int remining = total % 25;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++) {
            sb.append('z');    
        }
        sb.append((char)(remining + 'a'));
        for(int i = 0; i < n - times - 1; i++) {
            sb.append('a');
        }
        return sb.reverse().toString();
    }
}
