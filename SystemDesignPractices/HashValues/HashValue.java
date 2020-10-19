
public class HashValue {

	static int[] P;
	static int[] H;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ABACBA";
		int len = input.length();
		P = new int[len];
		H = new int[len];
		Preprocess(input, 3, 97);
		System.out.println("index from 1 to 2 : " + getHashValue(1,2,97));
		System.out.println("index from 4 to 5 : " + getHashValue(4,5,97));
	}

	
	public static void Preprocess(String input, int X, int Y) {
		for(int i = 0; i < input.length(); i++) {
			if(i == 0) {
				H[i] = input.charAt(i);
				P[i] = 1;
			} else {
				H[i] = (H[i-1] * X + input.charAt(i)) % Y;
				P[i] = (P[i-1]*X) % Y;
			}
		}
	}
	
	public static int getHashValue(int a, int b, int Y) {
		return (H[b] - H[a-1]*P[b - a + 1]) % Y;
	}
}
